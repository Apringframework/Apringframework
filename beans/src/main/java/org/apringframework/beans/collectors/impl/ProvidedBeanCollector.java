package org.apringframework.beans.collectors.impl;

//TODO("bean collector that collects bean classes which have @Bean method")

import org.apringframework.beans.annotations.Bean;
import org.apringframework.beans.collectors.BeanCollector;
import org.springframework.utilities.AnnotationUtils;
import org.springframework.utilities.arrays.ArrayCloner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/***
 * It collects beans provided by specific method.
 * So bean type is {@link Method} to be called later for instantiating bean object.
 * It can collect beans from classes provided as parameter of constructor, or by {@link RuntimeBeanCollector}
 * Default method marker annotation is {@link Bean}
 * <p>
 *     e.g. It collects methods with {@link org.apringframework.beans.annotations.Bean}
 *
 * </p>
 * @author Singlerr
 */
public final class ProvidedBeanCollector implements BeanCollector<Method> {

    private final List<Class<?>> targetClasses;

    private Class<? extends Annotation> targetAnnotation = Bean.class;

    private List<Method> collectedMethods;

    /***
     * Create {@link ProvidedBeanCollector} instance with classes to fetch beans
     * Classes passed to parameter will be deep-copied
     * @param targetClasses classes to fetch beans
     */
   public ProvidedBeanCollector(List<Class<?>> targetClasses){
       this.targetClasses = ArrayCloner.deepCopy(targetClasses);
   }

    /***
     * Create {@link ProvidedBeanCollector} instance and fetch beans
     * It will execute:
     * <p>
     *     1. Collect classes from {@link RuntimeBeanCollector}
     * </p>
     * @param beanCollector collector to fetch classes
     */
   public ProvidedBeanCollector(RuntimeBeanCollector beanCollector){
       this(beanCollector.getBeanModels());
   }

    /***
     * Set method marker annotation
     * {@link ProvidedBeanCollector} will fetch methods with method marker annotation
     * @param targetAnnotation target annotation
     */
   public void setMethodMarker(Class<? extends Annotation> targetAnnotation){
       this.targetAnnotation = targetAnnotation;
   }

   private void initialize(){
       collectedMethods = new ArrayList<>();
       for (Class<?> targetClass : targetClasses) {
            collectedMethods.addAll(AnnotationUtils.findMethodsWith(targetClass,targetAnnotation));
       }
   }
    /***
     * Return collected bean "models"
     * Bean can be several types, such as one provided by method, and another annotated by special annotation.
     * If previously fetched methods, it will return cached data.
     * If not, it fetches methods newly and saves as cache
     * @implNote avoid collecting bean object, which means instantiated beans. Consider collecting bean "classes", not "objects"
     * @return collected beans
     */
    @Override
    public List<Method> getBeanModels() {
        if(collectedMethods == null)
            initialize();
        return collectedMethods;
    }
}
