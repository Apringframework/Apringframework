package org.apringframework.beans.collectors;

import java.util.List;

/***
 * A collector that collects beans.
 * No matter how its implementations collect beans, everything is ok when it returns bean classes, not object.
 * Bean can be several types, such as one provided by method, and another annotated by special annotation.
 * This class has generic type so that its implementations can collect various types of bean
 * For example, bean collector can collect {@link Class}, {@link Object}.
 * In this case, if bean type is {@link Class}, it might be un-instantiated bean which need instantiation later
 * @implNote avoid collecting bean object, which means instantiated beans. Consider collecting bean "classes", not "objects"
 * @author Singlerr
 */
public interface BeanCollector<T> {

    /***
     * Return collected bean "models"
     * Bean can be several types, such as one provided by method, and another annotated by special annotation.
     * @implNote avoid collecting bean object, which means instantiated beans. Consider collecting bean "classes", not "objects"
     * @return collected beans
     */
    List<T> getBeanModels();
}
