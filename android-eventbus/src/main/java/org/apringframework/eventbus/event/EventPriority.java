package org.apringframework.eventbus.event;

import lombok.Getter;

/***
 * Priority of events.
 * Used as parameter of {@link EventHandler}
 * When there are two or more event handler with same priority, methods are called in order of {@link Class#getDeclaredMethods()}
 * @author Singlerr
 */
public enum EventPriority{
    HIGHEST,
    HIGH,
    MEDIUM,
    LOW,
    LOWEST
}
