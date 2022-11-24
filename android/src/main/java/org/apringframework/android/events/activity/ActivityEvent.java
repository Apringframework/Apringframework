package org.apringframework.android.events.activity;

import android.app.Activity;

import org.apringframework.android.context.AndroidApplicationContext;
import org.apringframework.context.Context;
import org.apringframework.eventbus.event.Event;

/***
 * event associated with activity {@link android.app.Activity}
 * @author Singlerr
 */
public abstract class ActivityEvent extends Event {

    private Activity activity;

    private String name;

    private AndroidApplicationContext context;

    public ActivityEvent(AndroidApplicationContext context,String name, Activity activity){
        this.activity = activity;
        this.context = context;
        this.name = name;
    }


    /***
     * Get the activity of this event
     * @return activity started
     */
    public Activity getActivity() {
        return activity;
    }

    public AndroidApplicationContext getContext() {
        return context;
    }

    public String getName() {
        return name;
    }
}
