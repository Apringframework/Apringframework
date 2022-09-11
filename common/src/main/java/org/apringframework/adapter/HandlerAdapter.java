package org.apringframework.adapter;

import org.apringframework.action.Action;
import org.apringframework.context.Context;
import org.apringframework.handler.Handler;

import lombok.NonNull;

/***
 * @author Singlerr
 */
public interface HandlerAdapter {
    /***
     * Check if {@param handler} is supported.
     * @param handler Handler to check.
     * @return true if support else false
     */
    boolean support(Handler handler);

    /***
     * Handle {@param action} with handler {@param handler}
     * @param action An action to handle.
     * @param handler An handler to handle {@param action}
     */
    void handle(Action action, Handler handler);
}
