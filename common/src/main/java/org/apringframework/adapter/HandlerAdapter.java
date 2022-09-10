package org.apringframework.adapter;

import org.apringframework.context.Context;
import org.apringframework.handler.Handler;

/***
 * @author Singlerr
 */
public interface HandlerAdapter {

    /***
     * Get handler from context.
     * @param context Context to get handler from.
     * @return {@link Handler} handler of context.
     */
    Handler getHandler(Context context);
}
