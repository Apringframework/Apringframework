package org.apringframework.bean;

import org.apringframework.bean.utils.BeanMethodDescriptor;

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

}
