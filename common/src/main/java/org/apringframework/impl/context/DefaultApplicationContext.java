package org.apringframework.impl.context;

import org.apringframework.bean.BeanFactoryDescriptor;
import org.apringframework.bean.fetch.BeanFactoryFetcher;
import org.apringframework.bean.utils.BeanHolder;
import org.apringframework.context.Context;
import org.apringframework.impl.bean.DefaultBeanFactoryDescriptor;

import java.util.ArrayList;
import java.util.List;

public final class DefaultApplicationContext implements Context {


    private List<BeanFactoryDescriptor> factoryDescriptors;

    private List<BeanHolder<?>> beanHolders;

    /***
     * Get active bean in current context by class.
     * @param beanClass class of bean to get
     * @return bean instance
     */
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return null;
    }

    /***
     * Get active bean in current context by name and class.
     * @param name name of bean (required to tell the same beans)
     * @param beanClass class of bean to get
     * @return bean instance
     */
    @Override
    public <T> T getBean(String name, Class<T> beanClass) {
        return null;
    }

    /***
     * Initialize bean factory with {@link BeanFactoryFetcher}
     * @param factoryFetcher {@link BeanFactoryFetcher}
     */
    @Override
    public void initialize(BeanFactoryFetcher factoryFetcher) {
        factoryDescriptors = new ArrayList<>();
        beanHolders = new ArrayList<>();
        for (Class<?> beanFactoryClass : factoryFetcher.getBeanFactories()) {
            factoryDescriptors.add(new DefaultBeanFactoryDescriptor(beanFactoryClass));
        }
    }
}
