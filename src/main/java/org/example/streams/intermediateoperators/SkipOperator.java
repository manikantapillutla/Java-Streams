package org.example.streams.intermediateoperators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkipOperator {
    public static void main(String args[]){
        List<Integer> l= Arrays.asList(2,3,4);

        List<Integer> skip=l.stream()
                .skip(1)
                .collect(Collectors.toList());

        System.out.print(skip);
    }
}
