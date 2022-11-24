package org.apringframework.beans.fetch;



import org.apringframework.beans.Configuration;

import java.util.Set;

/***
 * Defining basic architecture of bean factory fetcher.
 * Fetch classes annotated with {@link Configuration}
 * @author Singlerr
 */
public interface BeanFactoryFetcher {

    /***
     * Get bean factory classes annotated with {@link Configuration}
     * @return set of bean factory classes.
     */
    Set<Class<?>> getBeanFactories();
}
