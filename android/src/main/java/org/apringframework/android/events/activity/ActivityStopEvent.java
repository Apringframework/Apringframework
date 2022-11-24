package org.apringframework.android.events.activity;

import android.app.Activity;

import org.apringframework.android.context.AndroidApplicationContext;
import org.apringframework.eventbus.event.ListenerList;
import org.apringframework.eventbus.listener.MarkListenerList;

/***
 * event of activity stop.
 * Called on stop of activity
 * @author Singlerr
 */
public final class ActivityStopEvent extends ActivityEvent{

    @MarkListenerList
    private static final ListenerList listeners = new ListenerList();

    public ActivityStopEvent(AndroidApplicationContext context,String name, Activity activity) {
        super(context,name, activity);
    }

    /***
     * Get registered listener for this event.
     * @implNote To retain listeners,I suggest declaring {@link ListenerList} as static
     * @return registered listeners
     */
    @Override
    public ListenerList getListenerList() {
        return listeners;
    }
}
