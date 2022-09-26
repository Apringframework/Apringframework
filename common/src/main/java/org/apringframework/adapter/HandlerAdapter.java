package org.apringframework.adapter;

import org.apringframework.action.Action;
import org.apringframework.context.Context;
import org.apringframework.handler.Handler;
import org.apringframework.model.ModelOrView;

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
     * @param context current context
     * @param action An action to handle.
     * @param handler An handler to handle {@param action}
     * @return model or view {@link ModelOrView}
     */
    ModelOrView handle(Context context, Object action, Handler handler);
}
