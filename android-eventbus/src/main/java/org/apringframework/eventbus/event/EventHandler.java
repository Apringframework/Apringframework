package org.apringframework.eventbus.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.Getter;

/***
 * Annotation to notify handler method of {@link Event}
 * Annotate this annotation to handler method with {@link Event} parameter.
 * @author Singlerr
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {

    /***
     * Set priority of event handler method.
     * @see EventPriority
     */
    EventPriority priority() default EventPriority.MEDIUM;
}
