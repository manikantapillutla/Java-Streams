package org.example.streams.terminaloperator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CountOperator {
    public  static void main(String args[]) {
        List<Integer> l = Arrays.asList(2, 3, 4, 6, 7, 8, 9, 10);

        long count=l.stream()
                .filter(n->(n%2)==0)
                .count();

        System.out.print(count);
        }
    }
