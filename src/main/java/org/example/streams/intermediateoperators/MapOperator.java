package org.example.streams.intermediateoperators;

import java.util.Arrays;
import java.util.List;

public class MapOperator {
    public static void main(String args[]){
        List<Integer> l= Arrays.asList(1,2,3,4);
        l.stream()
                .map(n->n+2)
                .forEach(System.out::println);
    }
}
