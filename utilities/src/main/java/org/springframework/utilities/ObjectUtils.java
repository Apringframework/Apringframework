package org.springframework.utilities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ObjectUtils {
    public static Class<?>[] objectsToClasses(Object[] objects){
        Class<?>[] classes = new Class[objects.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = objects[i].getClass();
        }
        return classes;
    }
}
