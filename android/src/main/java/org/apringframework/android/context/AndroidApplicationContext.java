package org.apringframework.android.context;

import android.app.Activity;

import org.apringframework.eventbus.EventBus;
import org.apringframework.impl.context.DefaultApplicationContext;

import java.io.Serializable;

/***
 * implementation class of {@link org.apringframework.impl.context.DefaultApplicationContext} for android context.
 * @author Singlerr
 */
public final class AndroidApplicationContext extends DefaultApplicationContext implements Serializable {

    private Activity activity;

    private EventBus eventBus;

    public AndroidApplicationContext(Activity activity){
        this.activity = activity;
    }

    /***
     * Get current context activity e.g. currently running activity
     * @return context activity
     */
    public Activity getActivity() {
        return activity;
    }

    /***
     * Set an activity of context
     * @param activity activity to set
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /***
     * Get current event bus
     * @return event bus
     */
    public EventBus getEventBus() {
        return eventBus;
    }

    /***
     * Set current event bus
     * @param eventBus event bus
     */
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
