package org.apringframework.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/***
 * Annotated to bean factory class, which is to create beans.
 * @author Singlerr
 */
@Target({ElementType.TYPE,ElementType.TYPE_USE})
public @interface BeanFactory {
}
