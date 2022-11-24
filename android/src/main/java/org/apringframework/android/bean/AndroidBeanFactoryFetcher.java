package org.apringframework.android.bean;

import org.apringframework.bean.BeanFactory;
import org.apringframework.bean.fetch.BeanFactoryFetcher;
import org.springframework.utilities.AnnotationUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/***
 * Implementation class of {@link BeanFactoryFetcher} to fetch classes annotated with {@link BeanFactory}
 * @author Singlerr
 */
public final class AndroidBeanFactoryFetcher implements BeanFactoryFetcher {
    /***
     * Get bean factory classes annotated with {@link BeanFactory}
     * @return list of bean factory classes.
     */
    @Override
    public Set<Class<?>> getBeanFactories() {

        try {

            return new HashSet<>(AnnotationUtils.findClassesWith(BeanFactory.class));
        } catch (IOException e) {
            return null;
        }
    }
}
