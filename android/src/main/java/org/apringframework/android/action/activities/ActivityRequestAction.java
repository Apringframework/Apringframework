package org.apringframework.android.action.activities;

import android.app.Activity;

import org.apringframework.android.action.ActivityAction;

import kotlin.NotImplementedError;
import lombok.Getter;
import lombok.Setter;

/***
 * Action of requesting activity to start
 * Handling this action allows the application to return information of activity to start.
 * @author Singlerr
 */
public final class ActivityRequestAction extends ActivityAction {

    public ActivityRequestAction(String name){
        super(name, null);
    }

    @Getter
    private int activityLayout;

    @Override
    public Activity getActivity() {
        throw new IllegalStateException("Unsupported action!");
    }

    public static final class Builder{
        private ActivityRequestAction instance;

        public Builder activityName(String activityName){
            instance.name = activityName;
            return this;
        }
        public Builder activityLayout(int activityLayout){
            instance.activityLayout = activityLayout;
            return this;
        }
        public ActivityRequestAction build(){
            return instance;
        }
    }
}
