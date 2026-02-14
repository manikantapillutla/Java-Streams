package org.example.streams.intermediateoperators;

import java.util.Arrays;
import java.util.List;

public class PeekOperator {
    public static void main(String args[]){
        List<Integer> l= Arrays.asList(2,3,4);
       List<Integer> peek= l.stream()
                .peek(System.out::println)
                .map(n->n*n)
                .peek(System.out::println).toList();
    }
}
