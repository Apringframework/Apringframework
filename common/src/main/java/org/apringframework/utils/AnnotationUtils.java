package org.apringframework.utils;

import org.reflections.Reflections;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AnnotationUtils {

    public static Set<Class<?>> findClassesWith(Class<? extends Annotation> annotationClass) throws IOException {
        Reflections reflections = new Reflections("org.apringframework");
        return reflections.getTypesAnnotatedWith(annotationClass);
    }

    public static Set<Method> findMethodsWith(Class<?> cls, Class<? extends Annotation> annotationClass) throws IOException {
        Reflections reflections = new Reflections(cls.getName());
        return reflections.getMethodsAnnotatedWith(annotationClass);
    }
}
