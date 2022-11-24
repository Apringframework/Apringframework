package org.apringframework.dispatcher;


import org.apringframework.action.Action;
import org.apringframework.adapter.HandlerAdapter;
import org.apringframework.context.Context;
import org.apringframework.handler.Handler;

/***
 * @author Singlerr
 */
public interface ApplicationDispatcher {

    /***
     * Find a handler adapter for {@param handler}
     * @param handler An handler to find suitable handler for.
     * @return {@link HandlerAdapter} for {@param handler}
     */
    HandlerAdapter getHandlerAdapter(Handler handler);

    /***
     * Find a handler for {@param action }
     * @param action An action to find suitable handler for.
     * @return {@link HandlerAdapter} for {@param action}
     */
    Handler getHandler(Object action);
    /***
     * Dispatch action.
     * {@link ApplicationDispatcher#getHandlerAdapter(Handler)} to get action handler.
     * @param context Context of application.
     * @param action Action to dispatch.
     */
    void dispatch(Context context, Object action);

}
