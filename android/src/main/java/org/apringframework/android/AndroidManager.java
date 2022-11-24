package org.apringframework.android;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

/***
 * Manager class of android
 * Define methods e.g. start new activity e.t.c
 * @author Singlerr
 */
public final class AndroidManager {
    /**
     * Current {@link AndroidApplicationDispatcher}
     */
    private static AndroidApplicationDispatcher dispatcher;
    /***
     * Start new activity(intent) from context
     * @param androidContext context or activity to start new activity from.
     * @param intent intent to start
     */
    public static void startActivity(Context androidContext, Intent intent){
        androidContext.startActivity(intent);

    }

    /***
     * Set current {@link AndroidApplicationDispatcher}
     * Only work when current dispatcher is null to prevent replacing {@link AndroidApplicationDispatcher} by other, non-authorized class.
     * @param dispatcher {@link AndroidApplicationDispatcher} to set.
     */
    public static void setAndroidApplicationDispatcher(AndroidApplicationDispatcher dispatcher){
        if(AndroidManager.dispatcher == null)
            AndroidManager.dispatcher = dispatcher;
    }

    /***
     * Returns current {@link AndroidApplicationDispatcher}
     * @return current {@link AndroidApplicationDispatcher}
     */
    @Nullable
    public static AndroidApplicationDispatcher getDispatcher() {
        return dispatcher;
    }
}
