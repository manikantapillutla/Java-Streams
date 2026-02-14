package org.example.streams.level1supereasy;

import java.util.Arrays;
import java.util.List;

public class FirstElementGreaterThan10 {
    public static void main(String[] args){
        List<Integer> nums= Arrays.asList(1,2,3,4,5,16,7,18,9,10,11);
        nums.stream()
                .filter(n->n>10)
                .sorted()
                .limit(1)
                .forEach(System.out::println);

    }
}
