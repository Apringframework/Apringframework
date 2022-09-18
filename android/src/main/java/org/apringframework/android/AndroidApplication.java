package org.apringframework.android;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.apringframework.ApringApplication;

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
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onApplicationStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onApplicationStop();
    }
}
