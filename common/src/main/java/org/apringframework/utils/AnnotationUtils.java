package org.apringframework.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.List;

import eu.infomas.annotation.AnnotationDetector;
import eu.infomas.annotation.Cursor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AnnotationUtils {
    public static List<Class<?>> findClassesWith(Class<? extends Annotation> annotationClass) throws IOException {
        return AnnotationDetector.scanClassPath()
                .forAnnotations(annotationClass)
                .collect(Cursor::getType);
    }

    public static List<Method> findMethodsWith(Class<?> cls, Class<? extends Annotation> annotationClass) throws IOException {
        return AnnotationDetector.scanClassPath(cls.getPackage().getName())
                .forAnnotations(annotationClass)
                .on(ElementType.METHOD)
                .filter((file,name) -> name.endsWith(cls.getName().concat(".class")))
                .collect(Cursor::getMethod);
    }
}
