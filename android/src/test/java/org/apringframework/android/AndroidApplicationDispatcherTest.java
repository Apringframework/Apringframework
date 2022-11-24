package org.apringframework.android;

import junit.framework.TestCase;

import org.apringframework.android.context.AndroidApplicationContext;
import org.junit.Test;

public class AndroidApplicationDispatcherTest extends TestCase {

    @Test
    public void testActivityBeanFactory() {
        AndroidApplicationContext ctx = new AndroidApplicationContext(null);
        AndroidApplicationDispatcher dispatcher = new AndroidApplicationDispatcher(ctx);
        System.out.println();
    }
}