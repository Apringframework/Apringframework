package org.apringframework.eventbus.listener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/***
 * Marker of static instance of {@link org.apringframework.eventbus.event.ListenerList}
 * {@link org.apringframework.eventbus.EventBus} will fetch static fields annotated with {@link MarkListenerList}
 * @author Singlerr
 */
@Target({ElementType.FIELD})
public @interface MarkListenerList {
}
