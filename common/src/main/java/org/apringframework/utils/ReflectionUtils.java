package org.apringframework.utils;

import java.lang.reflect.Method;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReflectionUtils {
    public static Class<?>[] getParameterTypes(Method method){
        method.setAccessible(true);
        return method.getParameterTypes();
    }
}
