package org.example.streams.intermediateoperators;

import java.util.Arrays;
import java.util.List;

public class ReduceOperator {
    public static void  main(String args[]){
        List<Integer> l= Arrays.asList(2,3,4);
        final Integer sum=l.stream()
                .reduce(1,(a, b)->(a*b));

        System.out.print(sum);

    }
}
