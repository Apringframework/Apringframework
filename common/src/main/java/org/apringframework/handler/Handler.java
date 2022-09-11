package org.apringframework.handler;

import org.apringframework.action.Action;
import org.apringframework.context.Context;

/***
 * @author Singlerr
 */
public interface Handler {
    void handle(Context context, Object action);
}
