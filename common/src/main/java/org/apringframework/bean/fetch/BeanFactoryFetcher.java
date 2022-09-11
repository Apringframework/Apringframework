package org.apringframework.bean.fetch;

import java.util.List;

/***
 * Defining basic architecture of bean factory fetcher.
 * Fetch classes annotated with {@link org.apringframework.bean.BeanFactory}
 * @author Singlerr
 */
public interface BeanFactoryFetcher {

    /***
     * Get bean factory classes annotated with {@link org.apringframework.bean.BeanFactory}
     * @return list of bean factory classes.
     */
    List<Class<?>> getBeanFactories();
}
