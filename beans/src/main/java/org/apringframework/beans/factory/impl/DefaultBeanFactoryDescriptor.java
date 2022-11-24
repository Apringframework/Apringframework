package org.apringframework.beans.factory.impl;


import org.apringframework.beans.Configuration;
import org.apringframework.beans.BeanFactoryDescriptor;
import org.apringframework.beans.utils.BeanMethodDescriptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * Default implementation class of {@link BeanFactoryDescriptor}
 * @author Singlerr
 */
public final class DefaultBeanFactoryDescriptor implements BeanFactoryDescriptor {

    private Class<? extends @Configuration Object> factoryClass;


    public DefaultBeanFactoryDescriptor(Class<? extends @Configuration Object> factoryClass){
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
            if(declaredMethod.isAnnotationPresent(Configuration.class)){
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
