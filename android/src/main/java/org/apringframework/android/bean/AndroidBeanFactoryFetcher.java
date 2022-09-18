package org.apringframework.android.bean;

import org.apringframework.bean.BeanFactory;
import org.apringframework.bean.fetch.BeanFactoryFetcher;
import org.apringframework.utils.AnnotationUtils;

import java.io.IOException;
import java.util.List;

/***
 * Implementation class of {@link org.apringframework.bean.fetch.BeanFactoryFetcher} to fetch classes annotated with {@link org.apringframework.bean.BeanFactory}
 * @author Singlerr
 */
public final class AndroidBeanFactoryFetcher implements BeanFactoryFetcher {
    /***
     * Get bean factory classes annotated with {@link BeanFactory}
     * @return list of bean factory classes.
     */
    @Override
    public List<Class<?>> getBeanFactories() {
        try {
            return AnnotationUtils.findClassesWith(BeanFactory.class);
        } catch (IOException e) {
            return null;
        }
    }
}
