package org.apringframework.beans.factory.impl;


import org.apringframework.beans.utils.BeanMethodDescriptor;

import java.lang.reflect.Method;

/***
 * Default implementation class of {@link BeanMethodDescriptor}
 * @author Singlerr
 */
public final class DefaultBeanMethodDescriptor implements BeanMethodDescriptor {

    private Method method;

    public DefaultBeanMethodDescriptor(Method method){
        this.method = method;
    }

    /***
     * Get name of method.
     * e.g. getFoo() has name of "getFoo"
     * If you want to create bean instance with name "foo", define method with name "foo()"
     * @return name of method
     */
    @Override
    public String getName() {
        return method.getName();
    }

    /***
     * Get parameter types of method
     * @return parameter types of method
     */
    @Override
    public Class<?>[] getParameterTypes() {
        method.setAccessible(true);
        return method.getParameterTypes();
    }

    /***
     * Get return type of method.
     * @return return type of method
     */
    @Override
    public Class<?> getReturnType() {
        method.setAccessible(true);
        return method.getReturnType();
    }
}
