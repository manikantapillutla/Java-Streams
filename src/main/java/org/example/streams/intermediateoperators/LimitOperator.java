package org.example.streams.intermediateoperators;

import java.util.Arrays;
import java.util.List;

public class LimitOperator {
    public static void main(String args[]){
        List<Integer> l= Arrays.asList(1,2,3,4,5);
               l.stream()
                .limit(3)
                .forEach(System.out::println);
    }
}
