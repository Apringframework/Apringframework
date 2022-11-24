package org.apringframework.android.events.listener;

import org.apringframework.android.AndroidManager;
import org.apringframework.android.action.activities.ActivityInitializationAction;
import org.apringframework.android.events.activity.ActivityStartEvent;
import org.apringframework.eventbus.event.EventHandler;
import org.apringframework.eventbus.event.EventPriority;
import org.apringframework.eventbus.listener.Listener;

/***
 * Listener class for events associated with {@link android.app.Activity}
 * e.g. {@link org.apringframework.android.events.activity.ActivityStartEvent}
 */
public final class ActivityEventListener implements Listener {
    /***
     * Only listen events for dispatch {@link org.apringframework.android.AndroidApplicationDispatcher}
     * @param event event to dispatch
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onActivityStart(ActivityStartEvent event){
        if(AndroidManager.getDispatcher() == null)
            return;
        AndroidManager.getDispatcher().dispatch(event.getContext(), new ActivityInitializationAction(event.getName(), event.getActivity()));
    }
}
