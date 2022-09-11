package org.apringframework.context;

import org.apringframework.bean.fetch.BeanFactoryFetcher;

/***
 * Bean factory
 * @author Singlerr
 */
public interface BeanFactory {

    /***
     * Get active bean in current context by class.
     * @param beanClass class of bean to get
     * @param <T> type of bean
     * @return bean instance
     */
    <T> T getBean(Class<T> beanClass);

    /***
     * Get active bean in current context by name and class.
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
