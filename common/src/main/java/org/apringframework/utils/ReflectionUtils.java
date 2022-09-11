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

    public static Method getMethod(Class<?> containingClass, String name, Class<?> returnType, Class<?>[] parameterTypes){
        Method method = null;
        for (Method declaredMethod : containingClass.getDeclaredMethods()) {
            if(declaredMethod.getName().equals(name) && declaredMethod.getReturnType().equals(returnType)){
                for (int i = 0; i < declaredMethod.getParameterTypes().length; i++) {
                    if(! parameterTypes[i].equals(declaredMethod.getParameterTypes()[i]))
                        return null;
                    method = declaredMethod;
                }
            }
        }
        return method;
    }
}
