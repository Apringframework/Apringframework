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

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AnnotationUtils {

    public static List<Class<?>> findClassesWith(Class<? extends Annotation> annotationClass) throws IOException {
        ArrayList<Class<?>> classes = new ArrayList<>();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ImmutableSet<ClassPath.ClassInfo> loadedClasses = ClassPath.from(loader).getAllClasses();

        for (ClassPath.ClassInfo loadedClass : loadedClasses) {
            if (loadedClass.getName().contains("module-info"))
                continue;
            Class<?> cls = loadedClass.load();
            if (cls.isAnnotationPresent(annotationClass))
                classes.add(cls);
        }

        return Collections.unmodifiableList(classes);
    }
    public static List<Method> findMethodsWith(Class<?> containingClass, Class<? extends Annotation> annotationClass){
        Method[] methods = containingClass.getDeclaredMethods();
        ArrayList<Method> foundMethods = new ArrayList<>();
        for (Method method : methods) {
            if(method.isAnnotationPresent(annotationClass))
                foundMethods.add(method);
        }
        return Collections.unmodifiableList(foundMethods);
    }
    public static List<Field> findFieldsWith(Class<?> containingClass, Class<? extends Annotation> annotationClass){
        Field[] fields = containingClass.getDeclaredFields();
        ArrayList<Field> foundFields = new ArrayList<>();
        for (Field field : fields) {
            if(field.isAnnotationPresent(annotationClass))
                foundFields.add(field);
        }
        return Collections.unmodifiableList(foundFields);
    }

}
