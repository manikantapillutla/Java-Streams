package org.example.streams.terminaloperator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxOperator {
    public  static void main(String args[]) {

        List<Integer> l = Arrays.asList(2, 3, 4);

        final Optional<Integer> max = l.stream()
                .max(Comparator.naturalOrder());

        System.out.print(max.get());
    }
    }
