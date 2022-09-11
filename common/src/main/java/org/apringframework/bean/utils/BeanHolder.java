package org.apringframework.bean.utils;

/***
 * A simple bean holder to wrap bean instance safely.
 * @param <T> Bean type to hold
 */
public interface BeanHolder<T> {
    /***
     * Get currently held bean
     * @return currently held bean
     */
    T getBean();

    /***
     * Check if currently held bean is available.
     * What is "available?", it can be "bean is not null" or "bean is not empty"
     * @return availability of bean
     */
    boolean isBeanAvailable();
}
