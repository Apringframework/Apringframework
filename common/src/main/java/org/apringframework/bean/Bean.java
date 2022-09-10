package org.apringframework.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/***
 * Annotated to methods in bean factory {@link BeanFactory}
 * @see BeanFactory
 * @author Singlerr
 */
@Target(ElementType.METHOD)
public @interface Bean {

}
