package org.example.streams.intermediateoperators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedOperator {
    public static void main(String args[]){
        List<Integer> l= Arrays.asList(7,1,2,5,3,4);
        l.stream()
                .sorted()
                .forEach(System.out::println);

        l.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);



        List<String> names=Arrays.asList("MANI","KANTA","PILLUTLA","SOFWARE");
        List<String> sort = names.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .reversed())
                .toList();

        sort.forEach(System.out::println);
    }
}
