package org.apringframework.bean.utils.holders;

import org.apringframework.bean.utils.BeanHolder;

/***
 * bean holder without name
 * @author Singlerr
 */
public final class UnnamedBeanHolder<T> implements BeanHolder<T> {

    private T beanInstance;
    /***
     * Create new instance of {@link NamedBeanHolder<T>}
     * @param beanInstance instance of bean
     */
    public UnnamedBeanHolder(T beanInstance){
        this.beanInstance = beanInstance;
    }

    /***
     * Get currently held bean
     * @return currently held bean
     */
    @Override
    public T getBean() {
        return beanInstance;
    }

    /***
     * Check if currently held bean is available.
     * What is "available?", it can be "bean is not null" or "bean is not empty"
     * @return availability of bean
     */
    @Override
    public boolean isBeanAvailable() {
        return beanInstance != null;
    }

    @Override
    public Class<T> getBeanClass() {
        return (Class<T>) beanInstance.getClass();
    }
}
