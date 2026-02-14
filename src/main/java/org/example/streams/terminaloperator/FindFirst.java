package org.example.streams.terminaloperator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindFirst {
    public  static void main(String args[]) {
        List<Integer> l = Arrays.asList(7,2, 3, 4);

        final Optional<Integer> first= l.stream()
                .filter(n->n%2==1)
                .findFirst();

        System.out.println(first.get());

        }
    }
