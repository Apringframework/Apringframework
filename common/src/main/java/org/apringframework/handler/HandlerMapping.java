package org.apringframework.handler;

import org.apringframework.context.Context;

import lombok.NonNull;

/***
 * @author Singlerr
 */
public interface HandlerMapping {

    /***
     * Get handler from context.
     * @param context Context to get handler from.
     * @return {@link Handler} handler of context.
     */
    @NonNull
    Handler getHandler(Context context);
}
