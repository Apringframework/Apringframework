package org.apringframework.eventbus.impl;

import org.apringframework.eventbus.EventBus;
import org.apringframework.eventbus.event.Event;
import org.apringframework.eventbus.event.EventHandler;
import org.apringframework.eventbus.event.ListenerList;
import org.apringframework.eventbus.listener.Listener;
import org.apringframework.eventbus.listener.MarkListenerList;
import org.apringframework.eventbus.utils.Pair;
import org.springframework.utilities.AnnotationUtils;
import org.springframework.utilities.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/***
 * Simple implementation class of {@link EventBus}
 * No classes outside package "org.apringframework.eventbus" can access implementation class.
 */
public final class CachedEventBus implements EventBus{
    private ArrayList<Class<? extends Event>> registeredEventClasses;
    
    private ListenerList universalListeners;

    public CachedEventBus(){
        registeredEventClasses = new ArrayList<>();
        universalListeners = new ListenerList();
    }
    /***
     * Fire event.
     * Notify all event listeners listening {@link Event}
     * @param event event instance
     */
    @Override
    public void fireEvent(Event event) {
        if(! registeredEventClasses.contains(event.getClass()))
            throw new IllegalStateException(String.format("Cannot fire %s because not registered.", event.getClass().getName()));
        try{
            ListenerList listeners = getListenerList(event.getClass());

            ListenerList temp = new ListenerList();
            temp.addAll(listeners);
            temp.addAll(universalListeners);

            List<Pair<Method,Listener>> eventHandlerMethods = ReflectionUtils.flattenMethodsWith(listeners.toArray(new Listener[0]),EventHandler.class, Pair::new);

            Collections.sort(eventHandlerMethods, (o1, o2) -> o1.getFirst().getAnnotation(EventHandler.class).priority().compareTo(o2.getFirst().getAnnotation(EventHandler.class).priority()));

            for (Pair<Method,Listener> eventHandlerMethod : eventHandlerMethods) {
                eventHandlerMethod.getFirst().invoke(eventHandlerMethod.getSecond(),event);
            }

        }catch (IllegalAccessException | InvocationTargetException ex){
            throw new RuntimeException(ex);
        }
    }

    /***
     * Register event for event bus.
     * To call {@link EventBus#fireEvent(Event)}, register event before call.
     * @param eventClass event class
     */
    @Override
    public void registerEvent(Class<? extends Event> eventClass) {
        if(! registeredEventClasses.contains(eventClass))
            registeredEventClasses.add(eventClass);
    }

    /***
     * Register event listener for {@param eventClass}.
     * Listen specific event {@param eventClass}
     * Only events with {@param eventClass} fired notify listener.
     * @param eventClass event class to listen
     * @param listener listener to listen
     */
    @Override
    public void registerEventListener(Class<? extends Event> eventClass, Listener listener) {
        if(! registeredEventClasses.contains(eventClass))
            throw new IllegalStateException(String.format("Cannot fire %s because not registered.", eventClass));

        try {
            ListenerList listeners = getListenerList(eventClass);
            listeners.add(listener);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    /***
     * Register event listener for all registered events.
     * Listen all events
     * No matter which event is called, the listener will be called.
     * @param listener listener to listen all events
     */
    @Override
    public void registerEventsListener(Listener listener) {
        universalListeners.add(listener);
    }

    private ListenerList getListenerList(Class<? extends Event> eventClass) throws IllegalAccessException {
        List<Field> fieldsWithMarker = AnnotationUtils.findFieldsWith(eventClass, MarkListenerList.class);
        if(fieldsWithMarker.isEmpty())
            throw new IllegalStateException(String.format("A event class must have static '%s' field annotated with '%s.'",ListenerList.class.getName(),MarkListenerList.class));

        if(fieldsWithMarker.size() >= 2)
            throw new IllegalStateException(String.format("A event class must have one static '%s' field annotated with '%s.'", ListenerList.class.getName(), MarkListenerList.class.getName()));

        Field markedListenerList = fieldsWithMarker.get(0);

        if(! markedListenerList.getType().isAssignableFrom(ListenerList.class))
            throw new IllegalStateException(String.format("A field annotated with '%s' must be '%s'", MarkListenerList.class.getName(), ListenerList.class.getName()));

        if(!Modifier.isStatic(markedListenerList.getModifiers()))
            throw new IllegalStateException(String.format("A '%s' field annotated with '%s' must be static field.", ListenerList.class.getName(), MarkListenerList.class.getName()));

        markedListenerList.setAccessible(true);

        return (ListenerList) markedListenerList.get(null);
    }


}
