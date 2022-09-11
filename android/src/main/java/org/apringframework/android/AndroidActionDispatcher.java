package org.apringframework.android;

import org.apringframework.action.Action;
import org.apringframework.adapter.HandlerAdapter;
import org.apringframework.context.Context;
import org.apringframework.dispatcher.ActionDispatcher;
import org.apringframework.handler.Handler;
import org.apringframework.handler.HandlerMapping;

import java.util.List;

/***
 * {@link ActionDispatcher} implementation class for android.
 * @author Singlerr
 */
final class AndroidActionDispatcher implements ActionDispatcher {

    private List<HandlerMapping> handlerMappings;

    private List<HandlerAdapter> handlerAdapters;

    /***
     * Find a handler adapter for {@param handler}
     * @param handler An handler to find suitable handler for.
     * @return {@link HandlerAdapter} for {@param handler}
     */
    @Override
    public HandlerAdapter getHandlerAdapter(Handler handler) {
        return null;
    }

    /***
     * Find a handler for {@param action }
     * @param action An action to find suitable handler for.
     * @return {@link HandlerAdapter} for {@param action}
     */
    @Override
    public Handler getHandler(Action action) {
        return null;
    }

    /***
     * Dispatch action.
     * {@link ActionDispatcher#getHandlerAdapter(Handler)} to get action handler.
     * @param context Context of application.
     * @param action Action to dispatch.
     */
    @Override
    public void dispatch(Context context, Action action) {

    }
}
