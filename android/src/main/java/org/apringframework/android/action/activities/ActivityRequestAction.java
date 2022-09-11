package org.apringframework.android.action.activities;

import android.app.Activity;

import org.apringframework.android.action.ActivityAction;

import kotlin.NotImplementedError;

/***
 * Action of requesting activity to start
 * Handling this action allows the application to return information of activity to start.
 * @author Singlerr
 */
public final class ActivityRequestAction extends ActivityAction {

    public ActivityRequestAction(Activity activity){
        super(activity);
    }

    private String activityName;

    private int activityLayout;

    @Override
    public void execute() {
    }



    public static class Builder{

    }
}
