package org.apringframework.eventbus;

import org.apringframework.eventbus.event.Event;
import org.apringframework.eventbus.listener.Listener;

/***
 * Event bus manager class.
 * Register {@link org.apringframework.eventbus.event.Event}, {@link org.apringframework.eventbus.listener.Listener} and post {@link org.apringframework.eventbus.event.Event}
 */
public interface EventBus {

    static EventBus getInstance(){
        return new CachedEventBus();
    }

    /***
     * Fire event.
     * Notify all event listeners listening {@link Event}
     * @param event event instance
     */
    void fireEvent(Event event);

    /***
     * Register event for event bus.
     * To call {@link EventBus#fireEvent(Event)}, register event before call.
     * @param eventClass event class
     */
    void registerEvent(Class<? extends Event> eventClass);

    /***
     * Register event listener for {@param eventClass}.
     * Listen specific event {@param eventClass}
     * Only events with {@param eventClass} fired notify listener.
     * @param eventClass event class to listen
     * @param listener listener to listen
     */
    void registerEventListener(Class<? extends Event> eventClass, Listener listener);

    /***
     * Register event listener for all registered events.
     * Listen all events
     * No matter which event is called, the listener will be called.
     * @param listener listener to listen all events
     */
    void registerEventsListener(Listener listener);
}
