package org.apringframework.context;

import org.apringframework.bean.fetch.BeanFactoryFetcher;

import java.util.Map;
import java.util.Set;

/***
 * Bean factory
 * @author Singlerr
 */
public interface BeanFactory {
    /***
     * Fetch all registered beans with class {@param beanClass}
     * @implNote must return all beans, not only named beans.
     * @param beanClass bean class to fetch
     * @param <T> type of bean
     * @return all beans
     */
    <T> Set<T> getBeans(Class<T> beanClass);

    /***
     * Fetch all registered beans with class {@param beanClass}
     * @implNote must return named beans.
     * @param beanClass bean class to fetch
     * @param <T> type of bean
     * @return {@link Map} name of bean and bean instance.
     */
    <T> Map<String,T>  getNamedBeans(Class<T> beanClass);

    /***
     * Get active bean found first in current context by class.
     * @param beanClass class of bean to get
     * @param <T> type of bean
     * @return bean instance
     */
    <T> T getBean(Class<T> beanClass);

    /***
     * Get active bean found first in current context by name and class.
     * @param name name of bean (required to tell the same beans)
     * @param beanClass class of bean to get
     * @param <T> type of bean
     * @return bean instance
     */
    <T> T getBean(String name, Class<T> beanClass);

    /***
     * Initialize bean factory with {@link BeanFactoryFetcher}
     * @param factoryFetcher {@link BeanFactoryFetcher}
     */
    void initialize(BeanFactoryFetcher factoryFetcher);

}
