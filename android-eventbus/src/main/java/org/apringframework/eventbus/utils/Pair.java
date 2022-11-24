package org.apringframework.eventbus.utils;

/***
 * Simple wrapper class for binary values
 * @param <T> first value type
 * @param <T1> second value type
 */
public final class Pair<T,T1> {

    private T first;
    private T1 second;

    public Pair(T first,T1 second){
        this.first = first;
        this.second  = second;
    }

    public T getFirst() {
        return first;
    }

    public T1 getSecond() {
        return second;
    }
}
