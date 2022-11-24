package org.springframework.utilities;

import org.springframework.utilities.function.Supplier;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtils {
    public static <T> String joinToString(T[] objects, Supplier<T,String> stringGetter, String delimiter){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < objects.length - 1; i++) {
            builder.append(stringGetter.get(objects[i]));
            builder.append(delimiter);
        }
        builder.append(stringGetter.get(objects[objects.length - 1]));
        return builder.toString();
    }
}
