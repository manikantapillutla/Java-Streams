package org.example.streams.level2easy;

import java.util.*;
import java.util.stream.Collectors;

public class Programs {
    public static void main(String args[]){

//        Find all distinct elements** from a list (remove duplicates).
          List<Integer> listofIntegers= Arrays.asList(1,2,3,4,6,7,4,5,6,7,8,9,9);

          //METHOD 1
          Set<Integer> set= new HashSet<>(listofIntegers);
          System.out.println(set);

          //METHOD 2
          List<Integer> distictElements=listofIntegers.stream()
                  .distinct()
                  .toList();
          System.out.println(distictElements);

//        Find the average** of all numbers in a list.

           double d=  listofIntegers.stream()
                  .mapToInt(Integer::intValue)
                  .average()
                  .orElse(0.0);
           System.out.println(d);

//        Sort a list of integers** in ascending and descending order using streams.
         listofIntegers.stream()
                 .sorted(Comparator.reverseOrder())
                 .forEach(System.out::println);

//        Count how many strings start with a specific letter** (like "A").
        List<String> fruits= Arrays.asList("mango","apple","banana","avacado");

        List<String> fru=fruits.stream()
                .filter(fr->fr.startsWith("a"))
                .toList();
        System.out.println(fru);

//        Join all strings** in a list into a single comma-separated string.
         String s=fruits.stream()
                 .collect(Collectors.joining(","));

        System.out.println(s);

//        Check if all elements are positive numbers** .
        boolean b=listofIntegers.stream()
                .allMatch(n->n>0);

        System.out.println(b);

//        Check if any number is divisible by 3** .
        boolean divisible = listofIntegers.stream()
                .anyMatch(n->n%3==0);

        System.out.println(divisible);

//        Flatten** the list of list
        List<List<Integer>> listOfList=Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(5,6,7),Arrays.asList(10));

        List<Integer> list=listOfList.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println(list);

//        Find the first non-empty string** in a list .
        List<String> fruit= Arrays.asList("","","mango","apple","banana","avacado");

        List<String> nonemp=fruit.stream()
                .filter(st->!st.isBlank())
                .toList();
        System.out.println(nonemp);

        Optional<String> first= fruit.stream()
                .filter(st->!st.isBlank())
                .findFirst();
        System.out.println(first);

//        Find the second highest number** in a list using streams.

        Optional<Integer> high=listofIntegers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(high);



    }
}
