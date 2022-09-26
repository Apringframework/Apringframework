package org.apringframework.eventbus.event;

/***
 * Main class of event
 * Any events must implement {@link Event}
 * @implNote Do not modify things associated with {@link ListenerList}
 * @implNote Create static field of {@link ListenerList} and mark with {@link org.apringframework.eventbus.listener.MarkListenerList}
 * @author Singlerr
 */
public abstract class Event {

    /***
     * Get registered listener for this event.
     * @implNote To retain listeners,I suggest declaring {@link ListenerList} as static
     * @return registered listeners
     */
    public abstract ListenerList getListenerList();
}
