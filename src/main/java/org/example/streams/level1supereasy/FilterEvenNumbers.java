package org.example.streams.level1supereasy;

import java.util.Arrays;
import java.util.List;

public class FilterEvenNumbers {
    public static void main(String args[]){
        List<Integer> nums= Arrays.asList(1,2,3,4,5,6,7,8,9,0);
    nums.stream().filter(n->n%2==0).forEach(System.out::println);

    }
}
