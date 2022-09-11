package org.apringframework.impl.bean;

import org.apringframework.bean.Bean;
import org.apringframework.bean.BeanFactory;
import org.apringframework.bean.BeanFactoryDescriptor;
import org.apringframework.bean.utils.BeanMethodDescriptor;
import org.apringframework.impl.bean.utils.DefaultBeanMethodDescriptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 * Default implementation class of {@link org.apringframework.bean.BeanFactoryDescriptor}
 * @author Singlerr
 */
public final class DefaultBeanFactoryDescriptor implements BeanFactoryDescriptor {

    private Class<? extends @BeanFactory Object> factoryClass;


    public DefaultBeanFactoryDescriptor(Class<? extends @BeanFactory Object> factoryClass){
        this.factoryClass = factoryClass;
    }

    /***
     * Get bean method descriptors defined in current bean factory class
     * @return bean method descriptors of bean factory class
     */
    @Override
    public List<BeanMethodDescriptor> getBeanMethodDescriptors() {
        ArrayList<BeanMethodDescriptor> descriptors = new ArrayList<>();
        for (Method declaredMethod : factoryClass.getDeclaredMethods()) {
            if(declaredMethod.isAnnotationPresent(Bean.class)){
                descriptors.add(new DefaultBeanMethodDescriptor(declaredMethod));
            }
        }
        return Collections.unmodifiableList(descriptors);
    }

    /***
     * Get class of bean factory
     * @return class of bean factory
     */
    @Override
    public Class<?> getBeanFactoryClass() {
        return factoryClass;
    }


}
