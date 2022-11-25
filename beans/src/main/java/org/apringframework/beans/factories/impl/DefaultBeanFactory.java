package org.apringframework.beans.factories.impl;

import org.apringframework.beans.collectors.BeanCollector;
import org.apringframework.beans.factories.HierarchicalBeanFactory;
import org.springframework.utilities.annotations.Nullable;

import java.util.List;

/***
 * Default implementation of {@link HierarchicalBeanFactory}
 * @author Singlerr
 */
public class DefaultBeanFactory implements HierarchicalBeanFactory {

    private HierarchicalBeanFactory parent;

    private HierarchicalBeanFactory child;

    public DefaultBeanFactory(BeanCollector<?> beanCollector){

    }

    /***
     * @param clazz class of bean
     * @return beans of type stored in this bean factory
     */
    @Override
    public <T> List<T> getBeansOfType(Class<T> clazz) {
        return null;
    }

    /***
     * Core functionality of {@link HierarchicalBeanFactory}
     * By defining this method, {@link HierarchicalBeanFactory} is defined and can separate beans between parent and current.
     * @implNote It can returns null. e.g. Top {@link HierarchicalBeanFactory} has no parent,so {@link #getParent()} is null.
     * @return parent {@link HierarchicalBeanFactory} of this
     */
    @Nullable
    @Override
    public HierarchicalBeanFactory getParent() {
        return parent;
    }

    /***
     * Core functionality of {@link HierarchicalBeanFactory}
     * By defining this method, {@link HierarchicalBeanFactory} is defined and can separate beans between child and current.
     * {@link HierarchicalBeanFactory} has only one child bean factory. This hierarchy is a tree with no leaves, only body.
     * @implNote It can returns null. e.g. Bottom {@link HierarchicalBeanFactory} has no child,so {@link #getChild()} is null.
     * @return child {@link HierarchicalBeanFactory} of this
     */
    @Override
    @Nullable
    public HierarchicalBeanFactory getChild() {
        return child;
    }


    public void setChild(HierarchicalBeanFactory child) {
        this.child = child;
    }

    public void setParent(HierarchicalBeanFactory parent) {
        this.parent = parent;
    }
}
