package org.springframework.utilities.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/***
 * An annotation that means an object is "nullable"
 * An object is null or not null.
 * Be careful! It can be null
 * @author Singlerr
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Nullable {
}
