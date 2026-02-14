package org.example.streams.terminaloperator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AnyMatch {
    public  static void main(String args[]) {
        List<Integer> l = Arrays.asList(2, 3, 4,5,6,7);
        final boolean b=l.stream()
                .anyMatch(n->n%2==0);

        System.out.println(b);

    }
    }
