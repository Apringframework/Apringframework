package org.apringframework.android.utils;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

/***
 * Bundle builder for bundle.
 * Easily build bundle with builder.\
 * TODO("Create more methods to put data to bundle if need")
 * @author Singlerr
 */
public final class BundleBuilder {

    private final Bundle bundle;

    public BundleBuilder() {
        bundle = new Bundle();
    }

    public BundleBuilder withBoolean(String key, boolean value) {
        bundle.putBoolean(key, value);
        return this;
    }

    public BundleBuilder withBooleanArray(String key, boolean[] values) {
        bundle.putBooleanArray(key, values);
        return this;
    }

    public BundleBuilder withInteger(String key, int value) {
        bundle.putInt(key, value);
        return this;
    }

    public BundleBuilder withIntegerArray(String key, int[] values) {
        bundle.putIntArray(key, values);
        return this;
    }

    public BundleBuilder withIntegerList(String key, ArrayList<Integer> values) {
        bundle.putIntegerArrayList(key, values);
        return this;
    }

    public BundleBuilder withString(String key, String value) {
        bundle.putString(key, value);
        return this;
    }

    public BundleBuilder withSerializable(String key, Serializable value){
        bundle.putSerializable(key,value);
        return this;
    }

    public Bundle build() {
        return bundle;
    }
}
