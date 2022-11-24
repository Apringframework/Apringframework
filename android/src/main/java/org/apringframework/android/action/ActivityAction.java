package org.apringframework.android.action;

import android.app.Activity;

import org.apringframework.action.Action;
import org.apringframework.model.ModelOrView;

/***
 * Parent {@link org.apringframework.action.Action} implementation class for activity events.
 * Implement this class to create detail activity actions e.g. ActivityStartAction or ActivityResultAction
 * @author Singlerr
 */
public abstract class ActivityAction implements Action, ModelOrView {

    protected String name;

    private Activity activity;

    /***
     * Initialize action with activity.
     * {@link ActivityAction} must have activity.
     * @param activity
     */
    public ActivityAction(String name, Activity activity){
        this.activity = activity;
        this.name = name;
    }

    /***
     * Get owner activity of action.
     * @return owner activity of action
     */
    public Activity getActivity() {
        return activity;
    }

    public String getName() {
        return name;
    }
}
