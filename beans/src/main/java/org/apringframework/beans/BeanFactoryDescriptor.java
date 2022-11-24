package org.apringframework.beans;

import org.apringframework.beans.utils.BeanMethodDescriptor;

import java.util.List;

/***
 * Descriptor of bean factory.
 * It must offer method information annotated with {@link Bean}
 * @author Singlerr
 */
public interface BeanFactoryDescriptor {

    /***
     * Get bean method descriptors defined in current bean factory class
     * @return bean method descriptors of bean factory class
     */
    List<BeanMethodDescriptor> getBeanMethodDescriptors();

    /***
     * Get class of bean factory
     * @return class of bean factory
     */
    Class<?> getBeanFactoryClass();
}
