package org.apringframework.android.handler.adapters.activity;

import org.apringframework.adapter.HandlerAdapter;
import org.apringframework.android.handler.handlers.activity.SpecifiedActivityHandler;
import org.apringframework.context.Context;
import org.apringframework.handler.Handler;
import org.apringframework.model.ModelOrView;

public final class SpecifiedActivityHandlerAdapter implements HandlerAdapter {
    /***
     * Check if {@param handler} is supported.
     * @param handler Handler to check.
     * @return true if support else false
     */
    @Override
    public boolean support(Handler handler) {
        return handler instanceof SpecifiedActivityHandler;
    }

    /***
     * Handle {@param action} with handler {@param handler}
     * @param context current context
     * @param action An action to handle.
     * @param handler An handler to handle {@param action}
     * @return model or view {@link ModelOrView}
     */
    @Override
    public ModelOrView handle(Context context, Object action, Handler handler) {

        return null;
    }
}
