package org.apringframework.beans.factory;

import java.util.List;

/***
 * factory for generating/getting registered bean of type.
 * defines minimum requirements for bean factory classes.
 * @see org.apringframework.beans.factory.derivatives.MarkedBeanFactory
 * @see org.apringframework.beans.factory.derivatives.ProvidedBeanFactory
 * @author Singlerr
 */
public interface BeanFactory {


    <T> List<T> getBeansOfType(Class<T> clazz);

}
