package org.springframework.utilities;

import org.springframework.utilities.function.Supplier;
import org.springframework.utilities.function.TriSupplier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReflectionUtils {

    public static Object instantiate(Class<?> cls, Object... args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = cls.getDeclaredConstructor(ObjectUtils.objectsToClasses(args));
        return constructor.newInstance(args);
    }

    public static Object instantiateOrNull(Class<?> cls, Object... args){
        try{
            return instantiate(cls,args);
        }catch (Exception ex){
            return null;
        }
    }
    public static <T> T instantiateOrNullExact(Class<T> cls, Object... args){
        try{
            return (T) instantiate(cls,args);
        }catch (Exception ex){
            return null;
        }
    }
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
                }
                method = declaredMethod;
            }
        }
        return method;
    }

    public static List<Method> flattenMethodsWith(Class<?>[] classes, Class<? extends Annotation> annotationClass){
        ArrayList<Method> flattened = new ArrayList<>();
        for (Class<?> cls : classes) {
            flattened.addAll(AnnotationUtils.findMethodsWith(cls, annotationClass));
        }
        return Collections.unmodifiableList(flattened);
    }
    public static <T> List<T> flattenMethodsWith(Class<?>[] classes, Class<? extends Annotation> annotationClass, Supplier<Method,T> packer){
        ArrayList<T> flattened = new ArrayList<>();

        for (Class<?> cls : classes) {
            for(Method m : AnnotationUtils.findMethodsWith(cls,annotationClass)){
                flattened.add(packer.get(m));
            }
        }
        return Collections.unmodifiableList(flattened);
    }
    public static <T,T1> ArrayList<T1> flattenMethodsWith(T[] objects, Class<? extends Annotation> annotationClass, TriSupplier<Method, T,T1> packer){
        ArrayList<T1> flattened = new ArrayList<>();

        for (T obj : objects) {
            Class<?> cls = obj.getClass();
            for(Method m : AnnotationUtils.findMethodsWith(cls,annotationClass)){
                flattened.add(packer.get(m,obj));
            }
        }
        return flattened;
    }
}
