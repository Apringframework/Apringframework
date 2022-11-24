package org.apringframework.android.handler.mappings.activity;

import org.apringframework.android.action.ActivityAction;
import org.apringframework.android.handler.handlers.activity.UniversalActivityHandler;
import org.apringframework.context.Context;
import org.apringframework.handler.Handler;
import org.apringframework.handler.HandlerMapping;

public class ActivityHandlerMapping implements HandlerMapping {
    /***
     * Get handler from context.
     * @param context Context to get handler from.
     * @param action
     * @return {@link Handler} handler of context.
     */
    @Override
    public Handler getHandler(Context context, Object action) {
        if(! (action instanceof ActivityAction))
            return null;
        return new UniversalActivityHandler();
    }
}
