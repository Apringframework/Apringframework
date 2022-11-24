package org.apringframework.beans.collectors.impl;

import org.apringframework.beans.collectors.BeanCollector;
import org.springframework.utilities.AnnotationUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

/***
 * Collects bean classes annotated with specific annotation.
 * Only collects {@link Class}
 * @author Singlerr
 */
public final class RuntimeBeanCollector implements BeanCollector<Class<?>> {

    private final ClassLoader classLoader;

    private final Class<? extends Annotation> classMarker;

    private List<Class<?>> beanClasses;

    /***
     * Instantiate {@link RuntimeBeanCollector} with annotation
     * This collector will collect bean classes annotated with the annotation in parameter
     * @param classLoader class loader that this collector will look up
     * @param classMarker {@link RuntimeBeanCollector} will collect classes annotated with
     * @param collectNow if true, it collects classes when instantiated
     */
    public RuntimeBeanCollector(ClassLoader classLoader, Class<? extends Annotation> classMarker, boolean collectNow){
        this.classLoader = classLoader;
        this.classMarker = classMarker;

        if(collectNow){
            try {
                initialize();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void initialize() throws IOException {
        beanClasses = AnnotationUtils.findClassesWith(classLoader,classMarker);
    }

    /***
     * Return collected bean "models"
     * Bean can be several types, such as one provided by method, and another annotated by special annotation.
     * If {@link RuntimeBeanCollector} collected already on its instantiation, it only returns local variable.
     * If not, it collects when this method called and save cache.
     * @implNote avoid collecting bean object, which means instantiated beans. Consider collecting bean "classes", not "objects"
     * @return collected beans
     */
    @Override
    public List<Class<?>> getBeanModels() {
        if(beanClasses == null) {
            try {
                initialize();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return beanClasses;
    }
}
