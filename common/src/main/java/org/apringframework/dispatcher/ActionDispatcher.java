package org.apringframework.dispatcher;


import org.apringframework.action.Action;
import org.apringframework.adapter.HandlerAdapter;

/***
 * @author Singlerr
 */
public interface ActionDispatcher {
    /***
     * Find a handler adapter for {@param action}
     * @param action An action to find suitable handler for.
     * @return {@link HandlerAdapter} for {@param action}
     */
    HandlerAdapter getHandlerAdapter(Action action);
}
