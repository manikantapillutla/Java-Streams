package org.example.streams.terminaloperator;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinOperator {
    public  static void main(String args[]){

        List<Integer> l = Arrays.asList(2, 3, 4);

        final Optional<Integer> min= l.stream()
                .min(Comparator.naturalOrder());

            System.out.print(min.get());
    }
}
