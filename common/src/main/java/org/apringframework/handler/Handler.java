package org.apringframework.handler;

import org.apringframework.action.Action;
import org.apringframework.context.Context;

/***
 * Handler interface
 * @see HandlerMapping
 * @author Singlerr
 */
public interface Handler {
    /***
     * Handle {@param action}
     * @param context current context
     * @param action object to handle
     * @return result state of handler
     */
    boolean handle(Context context, Object action);
}
