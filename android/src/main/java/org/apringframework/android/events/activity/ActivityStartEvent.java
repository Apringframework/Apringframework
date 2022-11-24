package org.apringframework.android.events.activity;

import android.app.Activity;

import org.apringframework.android.context.AndroidApplicationContext;
import org.apringframework.eventbus.event.Cancellable;
import org.apringframework.eventbus.event.Event;
import org.apringframework.eventbus.event.ListenerList;
import org.apringframework.eventbus.listener.MarkListenerList;

/***
 * event of activity start.
 * Called on start of activity
 * @author Singlerr
 */
public final class ActivityStartEvent extends ActivityEvent implements Cancellable {

    @MarkListenerList
    private static final ListenerList listeners = new ListenerList();

    public ActivityStartEvent(AndroidApplicationContext context, String name, Activity activity){
        super(context,name,  activity);
    }

    private boolean cancelled;
    /***
     * Get registered listener for this event.
     * @implNote To retain listeners,I suggest declaring {@link ListenerList} as static
     * @return registered listeners
     */
    @Override
    public ListenerList getListenerList() {
        return listeners;
    }

    /***
     * Whether the event is cancelled or not.
     * @return true if cancelled else false
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /***
     * Set the event to be cancelled or not.
     * @param cancelled true if the event must be cancelled else false
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
