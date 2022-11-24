package org.apringframework.beans.factory.derivatives;

import org.apringframework.beans.factory.BeanFactory;
import org.springframework.utilities.function.Predicate;

import java.lang.annotation.Annotation;
import java.util.List;

/***
 * Derived class of {@link BeanFactory} for specially handling bean classes with specific annotations.
 * Handling classes annotated with annotations provided
 * <p>
 *     e.g.
 *     Some classes annotated with @Component can be handled.
 * </p>
 * @author Singlerr
 */
public interface MarkedBeanFactory extends BeanFactory {
    /***
     * Get instantiated object found first for class annotated with {@param annotationClass}
     * @param annotationClass which annotated to class
     * @return instantiated object
     */
    Object getBeanAnnotatedWith(Class<Annotation> annotationClass);
    /***
     * Get instantiated object found first for class annotated with {@param annotationClass}, filtered by {@param filter}
     * @param annotationClass which annotated to class
     * @param filter filter for object
     * @return instantiated object
     */
    Object getBeanAnnotatedWith(Class<Annotation> annotationClass, Predicate<Object> filter);
    /***
     * Get instantiated objects for class annotated with {@param annotationClass}
     * @param annotationClass which annotated to class
     * @return instantiated object
     */
    List<Object> getBeansAnnotatedWith(Class<Annotation> annotationClass);

    /***
     * Get instantiated object with name for class annotated with {@param annotationClass},  filtered by {@param filter}
     * @param annotationClass which annotated to class
     * @param filter filter for object
     * @return instantiated object
     */
    List<Object> getBeansAnnotatedWith(Class<Annotation> annotationClass, Predicate<Object> filter);
}
