package org.apringframework.android;

import org.apringframework.action.Action;
import org.apringframework.adapter.HandlerAdapter;
import org.apringframework.android.bean.AndroidBeanFactoryFetcher;
import org.apringframework.android.context.AndroidApplicationContext;
import org.apringframework.context.Context;
import org.apringframework.dispatcher.ApplicationDispatcher;
import org.apringframework.handler.Handler;
import org.apringframework.handler.HandlerMapping;
import org.apringframework.model.ModelOrView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * {@link ApplicationDispatcher} implementation class for android.
 * @author Singlerr
 */
final class AndroidApplicationDispatcher implements ApplicationDispatcher {

    private List<HandlerMapping> handlerMappings;

    private List<HandlerAdapter> handlerAdapters;

    private AndroidApplicationContext context;

    private AndroidBeanFactoryFetcher factoryFetcher;

    public AndroidApplicationDispatcher(AndroidApplicationContext context){
        this.context = context;
        initialize();
    }

    private void initialize(){
        this.factoryFetcher = new AndroidBeanFactoryFetcher();
        context.initialize(factoryFetcher);

        initializeHandlerMappings(context);
        initializeHandlerAdapters(context);
    }

    private void initializeHandlerMappings(Context context){
        if(handlerMappings == null)
            handlerMappings = new ArrayList<>();
        Set<HandlerMapping> mappings = context.getBeans(HandlerMapping.class);
        handlerMappings.addAll(mappings);
    }

    private void initializeHandlerAdapters(Context context){
        if(handlerAdapters == null)
            handlerAdapters = new ArrayList<>();
        Set<HandlerAdapter> adapters = context.getBeans(HandlerAdapter.class);
        handlerAdapters.addAll(adapters);
    }
    /***
     * Find a handler adapter for {@param handler}
     * @param handler An handler to find suitable handler for.
     * @return {@link HandlerAdapter} for {@param handler}
     */
    @Override
    public HandlerAdapter getHandlerAdapter(Handler handler) {
        for (HandlerAdapter handlerAdapter : handlerAdapters) {
            if(handlerAdapter.support(handler))
                return handlerAdapter;
        }
        return null;
    }
    /***
     * Find a handler for {@param action }
     * @param action An action to find suitable handler for.
     * @return {@link HandlerAdapter} for {@param action}
     */
    @Override
    public Handler getHandler(Object action) {
        for (HandlerMapping handlerMapping : handlerMappings) {
            Handler handler = handlerMapping.getHandler(context,action);
            if(handler != null)
                return handler;
        }
        return null;
    }

    /***
     * Dispatch action.
     * {@link ApplicationDispatcher#getHandlerAdapter(Handler)} to get action handler.
     * @param context Context of application.
     * @param action Action to dispatch.
     */
    @Override
    public void dispatch(Context context, Object action) {
        Handler handler = getHandler(action);

        HandlerAdapter adapter = getHandlerAdapter(handler);

        if(adapter == null)
            throw new IllegalStateException("Cannot find suitable handler adapter for " + action);

        if(handler.handle(context,action)){
            ModelOrView model = adapter.handle(context, action,handler);

        }
    }
}
