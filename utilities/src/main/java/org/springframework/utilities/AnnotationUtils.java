package org.springframework.utilities;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AnnotationUtils {

    /***
     * Find classes with specific annotation in class loader of current thread
     * @param annotationClass annotation annotated to class to find
     * @return classes annotated
     * @throws IOException
     */
    public List<Class<?>> findClassesWith(Class<? extends Annotation> annotationClass) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return findClassesWith(loader,annotationClass);
    }

    /***
     * Find classes with specific annotation in specific class loader
     * @param classLoader class loader to look up
     * @param annotationClass annotation annotated to class to find
     * @return unmodifiable list of classes annotated
     * @throws IOException
     */
    public List<Class<?>> findClassesWith(ClassLoader classLoader, Class<? extends Annotation> annotationClass) throws IOException{
        ArrayList<Class<?>> classes = new ArrayList<>();
        ImmutableSet<ClassPath.ClassInfo> loadedClasses = ClassPath.from(classLoader).getAllClasses();
        for (ClassPath.ClassInfo loadedClass : loadedClasses) {
            if (loadedClass.getName().contains("module-info"))
                continue;
            Class<?> cls = loadedClass.load();
            if (cls.isAnnotationPresent(annotationClass))
                classes.add(cls);
        }
        return Collections.unmodifiableList(classes);
    }

    /***
     * Find methods which annotated with specific annotation in specific class
     * @param containingClass class to find methods
     * @param annotationClass annotation annotated to method
     * @return unmodifiable list of methods annotated
     */
    public List<Method> findMethodsWith(Class<?> containingClass, Class<? extends Annotation> annotationClass){
        Method[] methods = containingClass.getDeclaredMethods();
        ArrayList<Method> foundMethods = new ArrayList<>();
        for (Method method : methods) {
            if(method.isAnnotationPresent(annotationClass))
                foundMethods.add(method);
        }
        return Collections.unmodifiableList(foundMethods);
    }

    /***
     * Find fields which annotated with specific annotation in specific class
     * @param containingClass class to find fields
     * @param annotationClass annotation annotated to field
     * @return unmodifiable list of fields annotated
     */
    public List<Field> findFieldsWith(Class<?> containingClass, Class<? extends Annotation> annotationClass){
        Field[] fields = containingClass.getDeclaredFields();
        ArrayList<Field> foundFields = new ArrayList<>();
        for (Field field : fields) {
            if(field.isAnnotationPresent(annotationClass))
                foundFields.add(field);
        }
        return Collections.unmodifiableList(foundFields);
    }

}
