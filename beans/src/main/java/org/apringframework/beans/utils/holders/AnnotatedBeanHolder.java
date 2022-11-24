package org.apringframework.beans.utils.holders;

import org.apringframework.beans.Configuration;

import java.lang.annotation.Annotation;

/***
 * Named bean holder specially designed for annotated classes(not {@link Configuration})
 * e.g. @Component, @Service etc.
 * @param <T> type of bean
 */
public final class AnnotatedBeanHolder<T> extends NamedBeanHolder<T>{
    private Class<Annotation> annotationClass;
    /***
     * Create new instance of {@link NamedBeanHolder<T>}
     * @param name bean name
     * @param annotation class of annotation annotated to {@link T}
     * @param beanInstance instance of bean
     */
    public AnnotatedBeanHolder(String name, Class<Annotation> annotation,  T beanInstance){
        super(name, beanInstance);
        this.annotationClass = annotation;
    }

    /***
     * Get class of annotation attached to {@link T}
     * @return annotation class
     */
    public Class<Annotation> getAnnotationClass(){
        return annotationClass;
    }
}
