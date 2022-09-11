package org.apringframework.bean.utils;

/***
 * Descriptor of bean method annotated with {@link org.apringframework.bean.Bean}
 * @author Singlerr
 */
public interface BeanMethodDescriptor {
    /***
     * Get name of method.
     * e.g. getFoo() has name of "getFoo"
     * If you want to create bean instance with name "foo", define method with name "foo()"
     * @return name of method
     */
    String getName();

    /***
     * Get parameter types of method
     * @return parameter types of method
     */
    Class<?>[] getParameterTypes();

    /***
     * Get return type of method.
     * @return return type of method
     */
    Class<?> getReturnType();
}
