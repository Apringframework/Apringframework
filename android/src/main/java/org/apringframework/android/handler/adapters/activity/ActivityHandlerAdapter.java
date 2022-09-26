package org.apringframework.android.handler.adapters.activity;

import android.app.Activity;
import android.content.Intent;

import org.apringframework.adapter.HandlerAdapter;
import org.apringframework.android.action.activities.ActivityRequestAction;
import org.apringframework.android.context.AndroidApplicationContext;
import org.apringframework.android.handler.handlers.activity.ActivityHandler;
import org.apringframework.android.impl.activity.ImplAppCompatActivity;
import org.apringframework.android.utils.BundleBuilder;
import org.apringframework.context.Context;
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
        return handler instanceof ActivityHandler;
    }

    /***
     * Handle {@param action} with handler {@param handler}
     * @param action An action to handle.
     * @param handler An handler to handle {@param action}
     * @return model or view {@link ModelOrView}
     */
    @Override
    public ModelOrView handle(Context context, Object action, Handler handler) {
        AndroidApplicationContext appContext = (AndroidApplicationContext) context;
        if (action instanceof ActivityRequestAction) {
            ActivityRequestAction reqAction = (ActivityRequestAction) action;

            Activity contextActivity = appContext.getActivity();

            Intent intent = new Intent(contextActivity, ImplAppCompatActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            intent.putExtras(new BundleBuilder()
                    .withInteger(ImplAppCompatActivity.KEY_ACTIVITY_LAYOUT, reqAction.getActivityLayout())
                    .withSerializable(ImplAppCompatActivity.KEY_CONTEXT, appContext)
                    .build());

            contextActivity.getApplication().startActivity(intent);
        }

        return null;
    }
}
