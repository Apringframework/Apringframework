package org.apringframework.beans.factory.derivatives.impl;

import org.apringframework.beans.Bean;
import org.apringframework.beans.factory.derivatives.ProvidedBeanFactory;
import org.apringframework.beans.fetch.BeanFactoryFetcher;
import org.springframework.utilities.AnnotationUtils;
import org.springframework.utilities.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/***
 * Default implementation class for {@link org.apringframework.beans.factory.derivatives.ProvidedBeanFactory}
 * @author Singlerr
 */
public final class DefaultProvidedBeanFactory implements ProvidedBeanFactory {

    private BeanFactoryFetcher factoryFetcher;

    public DefaultProvidedBeanFactory(BeanFactoryFetcher factoryFetcher){
        this.factoryFetcher = factoryFetcher;
        initialize(factoryFetcher);
    }

    @Override
    public <T> List<T> getBeansOfType(Class<T> clazz) {
        return null;
    }

    private void initialize(BeanFactoryFetcher factoryFetcher){
        for (Class<?> beanFactory : factoryFetcher.getBeanFactories()) {
            Object factoryInstance = ReflectionUtils.instantiateOrNull(beanFactory);

            if(factoryInstance == null)
                throw new IllegalStateException("Expected empty constructor but not found");

            List<Method> beanProviders = AnnotationUtils.findMethodsWith(beanFactory, Bean.class);
            
        }
    }
}
