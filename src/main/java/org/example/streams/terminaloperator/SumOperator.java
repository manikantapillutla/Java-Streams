package org.example.streams.terminaloperator;

import java.util.Arrays;
import java.util.List;

public class SumOperator {
    public static void main(String args[]) {
        List<Integer> l = Arrays.asList(2, 3, 4);
         final int sun=l.stream().mapToInt(Integer::intValue).sum();
         System.out.print(sun);
    }
}
