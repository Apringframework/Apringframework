package org.apringframework.beans;

import java.util.List;

/***
 * {@inheritDoc}
 * Default functionality of bean factory.
 * Bean factory is a factory that provides beans defined by user or default.
 * @author Singlerr
 */
public interface BeanFactory {

    /***
     * @param clazz class of bean
     * @param <T> type of bean
     * @return beans of type stored in this bean factory
     */
    <T> List<T> getBeansOfType(Class<T> clazz);
}
