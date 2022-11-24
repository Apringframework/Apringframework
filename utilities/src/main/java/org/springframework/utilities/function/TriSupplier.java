package org.springframework.utilities.function;

/***
 * Origin is {@link java.util.function.Function}
 * Avoid conflicting Android SDK Version(some android sdk version do not support {@link java.util.function.Function}
 * @param <T> type of parameter that will be passed to.
 * @param <U> type of second parameter
 * @param <R> return type
 */
public interface TriSupplier<T,U,R> {

    /***
     * Get {@link R}
     * Use {@link T} if needed.
     * @param param1 parameter
     * @param param2 parameter
     * @return value
     */
    R get(T param1,U param2);
}
