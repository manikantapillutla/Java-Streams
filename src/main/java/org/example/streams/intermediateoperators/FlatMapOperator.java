package org.example.streams.intermediateoperators;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlatMapOperator {
    public static void main(String args[]){
        List<List<Integer>> l= Arrays.asList(Arrays.asList(11,22,33,44),Arrays.asList(55,66,77,88));
        System.out.println(l);

        l.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

    List<List<String>> s= Arrays.asList(Arrays.asList("mani","kant"),Arrays.asList("pillutla","software"));
    System.out.println(s);

    s.stream()
            .flatMap(Collection::stream)
            .map(String::toUpperCase)
            .forEach(System.out::println);

    }
}
