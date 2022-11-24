package org.apringframework.android.bean.factories.activity;

import org.apringframework.android.handler.handlers.activity.UniversalActivityHandler;
import org.apringframework.bean.Bean;
import org.apringframework.bean.BeanFactory;
import org.apringframework.handler.Handler;

/***
 * factory of handler associated with activity
 * @author Singlerr
 */
@BeanFactory
public class ActivityHandlerBeanFactory {

    /***
     * Bean instantiator of activity handler
     * @return new instance of activity handler
     */
    @Bean
    public Handler activityHandler(){
        return new UniversalActivityHandler();
    }
}
