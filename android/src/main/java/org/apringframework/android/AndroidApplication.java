package org.apringframework.android;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.apringframework.ApringApplication;
import org.apringframework.android.context.AndroidApplicationContext;
import org.apringframework.android.events.activity.ActivityStartEvent;
import org.apringframework.android.events.activity.ActivityStopEvent;
import org.apringframework.eventbus.EventBus;
import org.apringframework.eventbus.impl.CachedEventBus;

/***
 * Entrypoint of apring framework.
 * By overriding {@link ApringApplication#onApplicationStart()} and {@link ApringApplication#onApplicationStop()}, it notifies start/stop of application.
 * @see ApringApplication
 * @author Singlerr
 */
public abstract class AndroidApplication extends AppCompatActivity implements ApringApplication{
    /***
     * DO NOT OVERRIDE THIS METHOD!
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationContext context = new AndroidApplicationContext(this);
        context.setEventBus(new CachedEventBus());

        registerEvents(context.getEventBus());

        AndroidApplicationDispatcher dispatcher = new AndroidApplicationDispatcher(context);
        AndroidManager.setAndroidApplicationDispatcher(dispatcher);
        onApplicationStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onApplicationStop();
    }

    private void registerEvents(EventBus eventBus){
        eventBus.registerEvent(ActivityStartEvent.class);
        eventBus.registerEvent(ActivityStopEvent.class);
    }
}
