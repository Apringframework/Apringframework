package org.apringframework.android.action.activities;

import android.app.Activity;

import org.apringframework.android.action.ActivityAction;

/***
 * Action of requesting activity to start
 * Handling this action allows the application to execute something on initialization of activity
 * @author Singlerr
 */
public final class ActivityInitializationAction extends ActivityAction {
    /***
     * Initialize action with activity.
     * {@link ActivityAction} must have activity.
     * @param activity
     */
    public ActivityInitializationAction(String name, Activity activity) {
        super(name, activity);
    }
}
