package org.apringframework.android.impl.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.apringframework.android.context.AndroidApplicationContext;
import org.apringframework.android.events.activity.ActivityStartEvent;

/***
 * Dummy implementation class of {@link androidx.appcompat.app.AppCompatActivity}
 * Exist to be instantiate activity with layout
 * @author Singlerr
 */
public final class ImplAppCompatActivity extends AppCompatActivity {
    public static final String KEY_ACTIVITY_LAYOUT = "key_activity_layout";
    public static final String KEY_CONTEXT = "key_context";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle dataBundle = getIntent().getExtras();
        if(dataBundle == null)
            throw new IllegalStateException(getClass().getName() + " must have bundle that has activity layout data");

        int activityLayout = dataBundle.getInt(KEY_ACTIVITY_LAYOUT,-1);
        if(activityLayout == -1)
            throw new IllegalStateException("Initializing activity requires layout of activity.");

        AndroidApplicationContext context = (AndroidApplicationContext) dataBundle.getSerializable(KEY_CONTEXT);
        context.setActivity(this);

        ActivityStartEvent event = new ActivityStartEvent(context,this);

        context.getEventBus().fireEvent(event);

        if(event.isCancelled())
            finish();

        setContentView(activityLayout);


    }
}
