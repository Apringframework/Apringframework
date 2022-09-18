package org.apringframework.android.context;

import android.app.Activity;

import org.apringframework.impl.context.DefaultApplicationContext;

/***
 * implementation class of {@link org.apringframework.impl.context.DefaultApplicationContext} for android context.
 * @author Singlerr
 */
public final class AndroidApplicationContext extends DefaultApplicationContext {

    private Activity activity;

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
}
