package org.apringframework.beans.collectors.impl;

import org.apringframework.beans.collectors.BeanCollector;
import org.springframework.utilities.arrays.ArrayCloner;

import java.util.Arrays;
import java.util.List;

/***
 * It handles as container of several {@link org.apringframework.beans.collectors.BeanCollector}
 * It "not" collects actual beans, rather contains {@link org.apringframework.beans.collectors.BeanCollector}
 * Used as passing multiple {@link org.apringframework.beans.collectors.BeanCollector} as one {@link org.apringframework.beans.collectors.BeanCollector}
 * @author Singlerr
 */
public final class GroupBeanCollector implements BeanCollector<BeanCollector<?>> {

    private final List<BeanCollector<?>> beanCollectors;

    public GroupBeanCollector(BeanCollector<?>... beanCollectors){
        this.beanCollectors = Arrays.asList(beanCollectors);
    }

    /***
     * Copies bean collectors passed to this constructor.
     * So don't worry possible modifications of list passed to.
     * @param beanCollectors bean collector list
     */
    public GroupBeanCollector(List<BeanCollector<?>> beanCollectors){
        this.beanCollectors = ArrayCloner.deepCopy(beanCollectors);
    }

    public void addBeanCollector(BeanCollector<?> beanCollector){
        this.beanCollectors.add(beanCollector);
    }

    /***
     * Return collected bean "models"
     * Bean can be several types, such as one provided by method, and another annotated by special annotation.
     * @implNote avoid collecting bean object, which means instantiated beans. Consider collecting bean "classes", not "objects"
     * @return collected beans
     */
    @Override
    public List<BeanCollector<?>> getBeanModels() {
        return beanCollectors;
    }
}
