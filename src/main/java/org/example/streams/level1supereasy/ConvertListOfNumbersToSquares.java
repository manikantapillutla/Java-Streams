package org.example.streams.level1supereasy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConvertListOfNumbersToSquares {
    public static void main(String args[]){
        List<Integer> listofIntegers= Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> squares=listofIntegers.stream()
                .map(n->n*n)
                .toList();

        System.out.println("Return squares of numbers in a list :"+squares);

        //Square even numbers from list
        List<Integer> evenSquares=listofIntegers.stream()
                .filter(n->n%2==0)
                .map(n->n*n)
                .collect(Collectors.toList());

        System.out.println("Squares of Even Numbers:"+evenSquares);

        //Count how many numbers are greater than 5 in List
        long countGreaterThan5=listofIntegers.stream()
                .filter(n->n>5)
                .count();
        System.out.println("Count of numbers greater than5:"+countGreaterThan5);

        // Find the sum/product of all numbers in list
        long sum=listofIntegers.stream()
                .reduce(0,(a,b)->(a+b));
        System.out.println("Sum of numbers using reduce:"+sum);

        long product=listofIntegers.stream()
                .reduce(1,(a,b)->(a*b));
        System.out.println(product);

//        Find sum of even numbers in list
        long sum1=listofIntegers.stream()
                .filter(n->n%2==0).reduce(0,(a,b)->(a+b));

        System.out.println("Sum of even numbers using reduce:"+sum1);
        long sum2=listofIntegers.stream()
                .filter(n->n%2==0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of even numbers using SUM:"+sum2);

//        Find the maximum number in list
        final Optional<Integer> max= listofIntegers.stream().max(Comparator.naturalOrder());
        System.out.println("max number in a list:"+max);

//        Sum of squares of even numbers in list
        long sum3= listofIntegers.stream().filter(n->n%2==0).map(n->n*n).reduce(0,(a,b)->(a+b));
        System.out.println("even squares:"+sum3);
    }
}
