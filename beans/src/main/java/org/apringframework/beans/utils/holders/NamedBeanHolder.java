package org.apringframework.beans.utils.holders;

import org.apringframework.beans.utils.BeanHolder;

/***
 * Bean holder with name
 * @param <T> Bean type to hold
 */
public class NamedBeanHolder<T> implements BeanHolder<T> {

    private T beanInstance;

    private String name;

    /***
     * Create new instance of {@link NamedBeanHolder<T>}
     * @param name bean name
     * @param beanInstance instance of bean
     */
    public NamedBeanHolder(String name, T beanInstance){
        this.name = name;
        this.beanInstance = beanInstance;
    }

    /***
     * Get name of bean
     * @return name of bean
     */
    public String getName() {
        return name;
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
