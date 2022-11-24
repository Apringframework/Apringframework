package org.springframework.utilities.arrays;

import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayCloner {

    public <T> List<T> deepCopy(List<T> original){
        return new ArrayList<>(original);
    }
}
