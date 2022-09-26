package org.apringframework.impl.context;

import org.apringframework.bean.BeanFactory;
import org.apringframework.bean.BeanFactoryDescriptor;
import org.apringframework.bean.fetch.BeanFactoryFetcher;
import org.apringframework.bean.utils.BeanHolder;
import org.apringframework.bean.utils.BeanMethodDescriptor;
import org.apringframework.bean.utils.holders.NamedBeanHolder;
import org.apringframework.context.Context;
import org.apringframework.impl.bean.DefaultBeanFactoryDescriptor;
import org.springframework.utilities.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/***
 * Simple implementation class of {@link Context}
 */
public class DefaultApplicationContext implements Context {


    private List<BeanFactoryDescriptor> factoryDescriptors;

    private Map<Class<? extends @BeanFactory Object>, Object> beanFactories;

    private List<BeanHolder<?>> beanHolders;


    private void updateBeans() {
        for (BeanFactoryDescriptor factoryDescriptor : factoryDescriptors) {
            for (BeanMethodDescriptor beanMethodDescriptor : factoryDescriptor.getBeanMethodDescriptors()) {
                Method method = ReflectionUtils.getMethod(factoryDescriptor.getBeanFactoryClass(), beanMethodDescriptor.getName(), beanMethodDescriptor.getReturnType(), beanMethodDescriptor.getParameterTypes());
                if (method == null)
                    throw new IllegalArgumentException("No bean method found for " + beanMethodDescriptor.getReturnType().getName());

                Object beanFactory;
                try {
                    beanFactory = instantiateBeanFactory(factoryDescriptor.getBeanFactoryClass());
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    throw new IllegalArgumentException("Cannot instantiate bean factory class.", e.getCause());
                }

                if (beanFactory == null) {
                    throw new IllegalArgumentException("Cannot find empty constructor or constructor with bean parameters");
                }
                try {
                    Object beanInstance = method.invoke(beanFactory);
                    beanHolders.add(new NamedBeanHolder<>(method.getName(), beanInstance));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalArgumentException("Cannot execute " + method.getName(), e.getCause());
                }


            }
        }
    }

    /***
     * Fetch all registered beans with class {@param beanClass}
     * @implNote must return all beans, not only named beans.
     * @param beanClass bean class to fetch
     * @return all beans
     */
    @Override
    public <T> Set<T> getBeans(Class<T> beanClass) {
        updateBeans();
        Set<T> beans = new HashSet<>();
        for (BeanHolder<?> beanHolder : beanHolders) {
            if (!beanClass.isAssignableFrom(beanHolder.getBeanClass()) || !beanHolder.isBeanAvailable())
                continue;
            beans.add((T) beanHolder.getBean());
        }
        return Collections.unmodifiableSet(beans);
    }

    /***
     * Fetch all registered beans with class {@param beanClass}
     * @param beanClass bean class to fetch
     * @return {@link Map} name of bean and bean instance.
     */
    @Override
    public <T> Map<String, T> getNamedBeans(Class<T> beanClass) {
        updateBeans();
        if (beanHolders == null)
            return null;

        Map<String, T> beans = new ConcurrentHashMap<>();

        for (BeanHolder<?> beanHolder : beanHolders) {
            if (!(beanHolder instanceof NamedBeanHolder<?>) || !beanHolder.getBeanClass().equals(beanClass) || !beanHolder.isBeanAvailable())
                continue;

            NamedBeanHolder<?> namedBeanHolder = (NamedBeanHolder<?>) beanHolder;
            beans.put(namedBeanHolder.getName(), (T) namedBeanHolder.getBean());
        }

        return beans;
    }

    /***
     * Get active bean in current context by class.
     * @param beanClass class of bean to get
     * @return bean instance
     */
    @Override
    public <T> T getBean(Class<T> beanClass) {
        updateBeans();
        if (beanHolders == null)
            return null;

        T bean = null;

        for (BeanHolder<?> beanHolder : beanHolders) {
            if (beanHolder.getBean().getClass().equals(beanClass) && beanHolder.isBeanAvailable())
                bean = (T) beanHolder.getBean();
        }

        if (bean == null) {
            for (BeanFactoryDescriptor factoryDescriptor : factoryDescriptors) {
                for (BeanMethodDescriptor beanMethodDescriptor : factoryDescriptor.getBeanMethodDescriptors()) {
                    if (beanMethodDescriptor.getReturnType().equals(beanClass)) {

                        Method method = ReflectionUtils.getMethod(factoryDescriptor.getBeanFactoryClass(), beanMethodDescriptor.getName(), beanMethodDescriptor.getReturnType(), beanMethodDescriptor.getParameterTypes());
                        if (method == null)
                            throw new IllegalArgumentException("No bean method found for " + beanClass.getName());

                        Object beanFactory;
                        try {
                            beanFactory = instantiateBeanFactory(factoryDescriptor.getBeanFactoryClass());
                        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                            throw new IllegalArgumentException("Cannot instantiate bean factory class.", e.getCause());
                        }

                        if (beanFactory == null) {
                            throw new IllegalArgumentException("Cannot find empty constructor or constructor with bean parameters");
                        }

                        try {
                            T beanInstance = (T) method.invoke(beanFactory);
                            bean = beanInstance;
                            beanHolders.add(new NamedBeanHolder<>(method.getName(), beanInstance));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new IllegalArgumentException("Cannot execute " + method.getName(), e.getCause());
                        }

                    }
                }
            }
        }
        return bean;
    }

    private Object getBeanFactory(Class<? extends @BeanFactory Object> beanFactoryClass) {
        return beanFactories.get(beanFactoryClass);
    }

    private boolean hasBeanFactory(Class<? extends @BeanFactory Object> beanFactoryClass) {
        return beanFactories.containsKey(beanFactoryClass);
    }

    private Object instantiateBeanFactory(Class<? extends @BeanFactory Object> beanFactoryClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if (hasBeanFactory(beanFactoryClass))
            return getBeanFactory(beanFactoryClass);

        for (Constructor<?> declaredConstructor : beanFactoryClass.getDeclaredConstructors()) {
            if (declaredConstructor.getParameterTypes().length == 0) {

                Object beanFactory = declaredConstructor.newInstance();

                beanFactories.put(beanFactoryClass, beanFactory);
                return beanFactory;
            }
        }

        for (Constructor<?> declaredConstructor : beanFactoryClass.getDeclaredConstructors()) {
            if (areAllParametersBean(declaredConstructor.getParameterTypes())) {
                Object[] params = orderBeansByParameters(declaredConstructor.getParameterTypes());

                Object beanFactory = declaredConstructor.newInstance(params);

                beanFactories.put(beanFactoryClass, beanFactory);

                return beanFactory;
            }
        }
        return null;
    }

    private Object[] orderBeansByParameters(Class<?>[] parameterTypes) {
        Object[] beans = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            beans[i] = getBean(parameterTypes[i]);
        }
        return beans;
    }

    private boolean areAllParametersBean(Class<?>[] parameterTypes) {
        for (Class<?> parameterType : parameterTypes) {
            if (getBean(parameterType) == null)
                return false;
        }
        return true;
    }

    /***
     * Get active bean in current context by name and class.
     * @param name name of bean (required to tell the same beans)
     * @param beanClass class of bean to get
     * @return bean instance
     */
    @Override
    public <T> T getBean(String name, Class<T> beanClass) {

        T bean = null;
        for (BeanHolder<?> beanHolder : beanHolders) {
            if (beanHolder instanceof NamedBeanHolder) {
                NamedBeanHolder<?> namedBeanHolder = (NamedBeanHolder<?>) beanHolder;
                if (namedBeanHolder.getName().equals(name) && namedBeanHolder.getBeanClass().equals(beanClass) && namedBeanHolder.isBeanAvailable())
                    bean = (T) namedBeanHolder.getBean();
            }
        }

        if (bean == null) {
            for (BeanFactoryDescriptor factoryDescriptor : factoryDescriptors) {
                for (BeanMethodDescriptor beanMethodDescriptor : factoryDescriptor.getBeanMethodDescriptors()) {
                    if (beanMethodDescriptor.getReturnType().equals(beanClass)) {

                        Method method = ReflectionUtils.getMethod(factoryDescriptor.getBeanFactoryClass(), beanMethodDescriptor.getName(), beanMethodDescriptor.getReturnType(), beanMethodDescriptor.getParameterTypes());
                        if (method == null)
                            throw new IllegalArgumentException("No bean method found for " + beanClass.getName());

                        Object beanFactory;
                        try {
                            beanFactory = instantiateBeanFactory(factoryDescriptor.getBeanFactoryClass());
                        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                            throw new IllegalArgumentException("Cannot instantiate bean factory class.", e.getCause());
                        }

                        if (beanFactory == null) {
                            throw new IllegalArgumentException("Cannot find empty constructor or constructor with bean parameters");
                        }

                        try {
                            T beanInstance = (T) method.invoke(beanFactory);
                            beanHolders.add(new NamedBeanHolder<>(method.getName(), beanInstance));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new IllegalArgumentException("Cannot execute " + method.getName(), e.getCause());
                        }

                    }
                }
            }
        }
        return bean;
    }

    /***
     * Initialize bean factory with {@link BeanFactoryFetcher}
     * @param factoryFetcher {@link BeanFactoryFetcher}
     */
    @Override
    public void initialize(BeanFactoryFetcher factoryFetcher) {
        factoryDescriptors = new ArrayList<>();
        beanHolders = new ArrayList<>();
        beanFactories = new ConcurrentHashMap<>();
        for (Class<?> beanFactoryClass : factoryFetcher.getBeanFactories()) {
            factoryDescriptors.add(new DefaultBeanFactoryDescriptor(beanFactoryClass));
        }
    }
}
