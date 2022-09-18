package org.apringframework.android.bean.factories.activity;


import org.apringframework.android.handler.mappings.activity.ActivityHandlerMapping;
import org.apringframework.bean.Bean;
import org.apringframework.bean.BeanFactory;

/***
 * factory of handler mapping associated with activity
 * @author Singlerr
 */
@BeanFactory
public class ActivityHandlerMappingsBeanFactory {
    /***
     * Bean instantiator of activity handler mapping
     * @return new instance of activity handler mapping
     */
    @Bean
    public ActivityHandlerMapping activityHandlerMapping(){
        return new ActivityHandlerMapping();
    }
}
