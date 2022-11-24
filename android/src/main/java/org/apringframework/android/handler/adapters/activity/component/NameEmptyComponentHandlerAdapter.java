package org.apringframework.android.handler.adapters.activity.component;

import org.apringframework.adapter.HandlerAdapter;
import org.apringframework.context.Context;
import org.apringframework.handler.Handler;
import org.apringframework.model.ModelOrView;

/***
 * Sub handler adapter for {@link org.apringframework.android.handler.adapters.activity.SpecifiedActivityHandlerAdapter}
 * Do not create bean factory for this class!
 * @author Singlerr
 */
public final class NameEmptyComponentHandlerAdapter implements HandlerAdapter {

    /***
     * Check if {@param handler} is supported.
     * @param handler Handler to check.
     * @return true if support else false
     */
    @Override
    public boolean support(Handler handler) {
        //Set to false to prevent from being called directly from dispatcher
        return false;
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
