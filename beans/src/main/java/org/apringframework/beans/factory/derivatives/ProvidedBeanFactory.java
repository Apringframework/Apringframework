package org.apringframework.beans.factory.derivatives;

import org.apringframework.beans.Configuration;
import org.apringframework.beans.factory.BeanFactory;

/***
 * Derived class of {@link BeanFactory} for specially handling bean classes provided by specific bean factory.
 * A bean factory class annotated with {@link Configuration} and methods with {@link org.apringframework.beans.Bean} can be targeted.
 * <p>
 *     e.g.
 *     Some classes annotated with @BeanFactory can be handled.
 * </p>
 * @author Singlerr
 */
public interface ProvidedBeanFactory extends BeanFactory{
}
