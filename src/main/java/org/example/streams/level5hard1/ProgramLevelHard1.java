package org.example.streams.level5hard1;

import org.example.streams.level3intermediate1.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgramLevelHard1 {
    public static void main(String args[]){
//        Find the Most Common First Letter Among All Employee Names
        List<Employee> employees= Arrays.asList(
                new Employee(1,"John","HR",50000),
                new Employee(2,"Alice","IT",70000),
                new Employee(3,"Bob","Finance",45000),
                new Employee(4,"David","IT",90000),
                new Employee(5,"Mike","IT",60000),
                new Employee(6,"Jane","HR",65000)
        );

        Map<Character, Long> collect = employees.stream()
                .map(e -> e.getName().charAt(0))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
        System.out.println(collect);

        Optional<Map.Entry<Character, Long>> max = collect.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.println(max);



//        Given a list of integers, compute the average of every 3-element sliding window
         List<Integer> list= Arrays.asList(4,8,15,16,23,42);
         int window =4;
                 ;
        List<Integer> list1 = IntStream.range(0, list.size() - (window-1))
                .mapToObj(i -> (list.get(i) + list.get(i + 1) + list.get(i + 2)+list.get(i+3)) / window)
                .toList();

        System.out.println(list1);


//        List<Double> list2 = IntStream.range(0, list.size() - (window - 1))
//                .mapToObj(i -> list1.subList(i, i + window))
//                .map(w -> w.stream()
//                        .mapToInt(Integer::intValue)
//                        .average()
//                        .orElse(0.0)
//                ).toList();
//
//        System.out.println(list2);


//        Find the Longest Word in a Sentence Ignoring Case and Punctuation
          String sentence=" The quick, brown fox jumped over the lazy dog!";
        String s = Arrays.stream(
                        sentence.toLowerCase()
                                .replaceAll("[^a-z\\s]", "")
                                .split(" ")
                ).max(Comparator.comparing(String::length))
                .orElse("");
        System.out.println(s);


//        Find Top 3 Most Frequent Words in a Paragraph
         String paragraph="Java is great. Java is object oriented. Java streams are powerful, and Java is functional Programming.";
        Map<String, Long> collect1 = Arrays.stream(
                paragraph.toLowerCase()
                        .replaceAll("[^a-z\\s]", "")
                        .split(" ")
        ).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ));

        System.out.println(collect1);

        List<Map.Entry<String, Long>> list2 = collect1.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .toList();
        System.out.println(list2);
//        Reverse Each Word in a Sentence Using Streams
        String sentence1="Java streams are powerful";

        String collect2 = Arrays.stream(
                        sentence1.split(" ")
                ).map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(collect2);

        String collect3 = Arrays.stream(
                        sentence1.split(" ")
                ).map(word -> Arrays.stream(word.split(""))
                        .reduce("", (rev, ch) -> ch + rev)
                )
                .collect(Collectors.joining(" "));
        System.out.println(collect3);


    }

}
