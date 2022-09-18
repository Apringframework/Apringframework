package org.apringframework.bean.fetch;



import java.util.List;
import java.util.Set;

/***
 * Defining basic architecture of bean factory fetcher.
 * Fetch classes annotated with {@link org.apringframework.bean.BeanFactory}
 * @author Singlerr
 */
public interface BeanFactoryFetcher {

    /***
     * Get bean factory classes annotated with {@link org.apringframework.bean.BeanFactory}
     * @return set of bean factory classes.
     */
    Set<Class<?>> getBeanFactories();
}
