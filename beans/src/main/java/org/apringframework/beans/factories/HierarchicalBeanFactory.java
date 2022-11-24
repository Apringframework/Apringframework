package org.apringframework.beans.factories;

import org.apringframework.beans.BeanFactory;
import org.springframework.utilities.annotations.Nullable;

/***
 * Bean factory that stores beans in hierarchy.
 * It is designed for enhancing performance of fetching beans by separating beans.
 * Like ipv4, bean factory can exist in hierarchy A, B, C.
 * It may have no parent bean factory and no child bean factory,which means single bean factory.
 * Either parent bean factory or child bean factory must be {@link HierarchicalBeanFactory} or its super classes.
 * <p>
 *     e.g.
 *     A bean factory can have system bean factory which has default beans, user-defined bean factory which has beans defined by user.
 *     Then system bean factory may have user-defined bean factory as child, and it will be the parent of user-defined bean factory.
 * </p>
 * @author Singlerr
 */
public interface HierarchicalBeanFactory extends BeanFactory {

    /***
     * Core functionality of {@link HierarchicalBeanFactory}
     * By defining this method, {@link HierarchicalBeanFactory} is defined and can separate beans between parent and current.
     * @implNote It can returns null. e.g. Top {@link HierarchicalBeanFactory} has no parent,so {@link #getParent()} is null.
     * @return parent {@link HierarchicalBeanFactory} of this
     */
    @Nullable
    HierarchicalBeanFactory getParent();

    /***
     * Core functionality of {@link HierarchicalBeanFactory}
     * By defining this method, {@link HierarchicalBeanFactory} is defined and can separate beans between child and current.
     * {@link HierarchicalBeanFactory} has only one child bean factory. This hierarchy is a tree with no leaves, only body.
     * @implNote It can returns null. e.g. Bottom {@link HierarchicalBeanFactory} has no child,so {@link #getChild()} is null.
     * @return child {@link HierarchicalBeanFactory} of this
     */
    @Nullable
    HierarchicalBeanFactory getChild();
}
