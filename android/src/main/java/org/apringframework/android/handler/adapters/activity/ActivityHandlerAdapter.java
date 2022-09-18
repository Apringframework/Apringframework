package org.apringframework.android.handler.adapters.activity;

import org.apringframework.adapter.HandlerAdapter;
import org.apringframework.handler.Handler;
import org.apringframework.model.ModelOrView;

public class ActivityHandlerAdapter implements HandlerAdapter {
    /***
     * Check if {@param handler} is supported.
     * @param handler Handler to check.
     * @return true if support else false
     */
    @Override
    public boolean support(Handler handler) {
        return false;
    }

    /***
     * Handle {@param action} with handler {@param handler}
     * @param action An action to handle.
     * @param handler An handler to handle {@param action}
     * @return model or view {@link ModelOrView}
     */
    @Override
    public ModelOrView handle(Object action, Handler handler) {
        return null;
    }
}
