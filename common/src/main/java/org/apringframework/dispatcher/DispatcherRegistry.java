package org.apringframework.dispatcher;

import com.sun.istack.internal.Nullable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/***
 * Registry of dispatcher.
 * Use as singleton container of dispatcher.
 * @author Singlerr
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DispatcherRegistry {
    private static ApplicationDispatcher dispatcher;

    /***
     * Get current action dispatcher in thread.
     * @return current action dispatcher
     */
    @Nullable
    public static ApplicationDispatcher getDispatcher() {
        return dispatcher;
    }

    /***
     * Set action dispatcher
     * @param dispatcher action dispatcher
     */
    public static void setDispatcher(ApplicationDispatcher dispatcher) {
        DispatcherRegistry.dispatcher = dispatcher;
    }
}
