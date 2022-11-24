package org.springframework.utilities.function;

/***
 * Origin is {@link java.util.function.Function}
 * Avoid conflicting Android SDK Version(some android sdk version do not support {@link java.util.function.Function}
 * @param <T> type of parameter that will be passed to.
 * @param <U> return type
 */
public interface Supplier<T,U> {

    /***
     * Get {@link U}
     * Use {@link T} if needed.
     * @param param parameter
     * @return value
     */
    U get(T param);
}
