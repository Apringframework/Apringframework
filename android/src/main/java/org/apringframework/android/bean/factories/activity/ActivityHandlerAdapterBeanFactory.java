package org.apringframework.android.bean.factories.activity;

import org.apringframework.adapter.HandlerAdapter;
import org.apringframework.android.handler.adapters.activity.ActivityHandlerAdapter;
import org.apringframework.bean.Bean;
import org.apringframework.bean.BeanFactory;

/***
 * factory of handler adapter associated with activity
 * @author Singlerr
 */
@BeanFactory
public class ActivityHandlerAdapterBeanFactory {
    /***
     * Bean instantiator of activity handler adapter
     * @return new instance of activity handler adapter
     */
    @Bean
    public HandlerAdapter activityHandlerAdapter(){
        return new ActivityHandlerAdapter();
    }
}
