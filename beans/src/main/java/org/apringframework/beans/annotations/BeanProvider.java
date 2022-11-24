package org.apringframework.beans.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * Annotated to a class which has bean provider method, especially {@link Bean}
 * A bean provider class must have this annotation
 * @author Singlerr
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface BeanProvider {
}
