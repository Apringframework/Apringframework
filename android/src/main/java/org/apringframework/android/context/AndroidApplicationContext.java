package org.apringframework.android.context;

import android.app.Activity;

import org.apringframework.android.controller.Component;
import org.apringframework.bean.fetch.BeanFactoryFetcher;
import org.apringframework.eventbus.EventBus;
import org.apringframework.impl.context.DefaultApplicationContext;
import org.springframework.utilities.AnnotationUtils;
import org.springframework.utilities.ObjectUtils;
import org.springframework.utilities.StringUtils;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Logger;

/***
 * implementation class of {@link org.apringframework.impl.context.DefaultApplicationContext} for android context.
 * @author Singlerr
 */
public final class AndroidApplicationContext extends DefaultApplicationContext implements Serializable {

    private Activity activity;

    private EventBus eventBus;

    private final Logger logger = Logger.getLogger("android-mvc");

    public AndroidApplicationContext(Activity activity){
        this.activity = activity;
    }

    /***
     * Get current context activity e.g. currently running activity
     * @return context activity
     */
    public Activity getActivity() {
        return activity;
    }

    /***
     * Set an activity of context
     * @param activity activity to set
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /***
     * Get current event bus
     * @return event bus
     */
    public EventBus getEventBus() {
        return eventBus;
    }

    /***
     * Set current event bus
     * @param eventBus event bus
     */
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }


    @Override
    public void initialize(BeanFactoryFetcher factoryFetcher) {
        super.initialize(factoryFetcher);
        //Initialize classes with @Component
        try{
            List<Class<?>> componentClasses = AnnotationUtils.findClassesWith(Component.class);
            for (Class<?> componentClass : componentClasses) {
                addNamedBean(componentClass.getSimpleName(),initialize(componentClass));
            }
        }catch (IOException ex){
            throw new IllegalStateException("Cannot initialize classes annotated with @Component! These classes will not work properly.");
        }


    }

    private Object initialize(Class<?> cls, Object... params){
        try {
            Constructor<?> constructor = cls.getDeclaredConstructor(ObjectUtils.objectsToClasses(params));
            return constructor.newInstance(params);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Cannot find a declared constructor with parameter types : " + StringUtils.joinToString(params,(o) -> o.getClass().getName(),","),e.getCause());
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new IllegalStateException("Cannot create new instance with parameter types : " + StringUtils.joinToString(params,(o) -> o.getClass().getName(),","),e.getCause());
        }

    }
}
