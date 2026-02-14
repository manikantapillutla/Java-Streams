package org.example.streams.level4intermediate2;


import org.example.streams.level3intermediate1.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProgramLevel4Intermediate2 {
    public static void main(String args[]){
//        Find the highest-paid employee in each department
        List<Employee> employees= Arrays.asList(
                new Employee(1,"John","HR",50000),
                new Employee(2,"Alice","IT",70000),
                new Employee(3,"Bob","Finance",45000),
                new Employee(4,"David","IT",90000),
                new Employee(5,"Mike","IT",60000)
        );

        Map<String, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.toList()
                ));
        System.out.println(collect);

        Map<String, Optional<Employee>> collect1 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));
        System.out.println(collect1);



//        Find all departments with more than 2 employees
        Map<String, Long> collect2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(collect2);

        List<Map.Entry<String, Long>> list = collect2.entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .toList();

        System.out.println(list);

        List<String> list1 = collect2.entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list1);

        List<String> list2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 2)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list2);


//        Find department with the highest average salary
        Map<String, Double> collect3 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println(collect3);

        Map.Entry<String, Double> stringDoubleEntry = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println(stringDoubleEntry);

//        Find Most Frequent Character In String

        String input="banana";

        Map<Character, Long> collect4 = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(collect4);

        Map.Entry<Character, Long> characterLongEntry = collect4.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();


        System.out.println(characterLongEntry);


//        Find First Non Repeating Character In String
        String str = "swiss";

        Map<Character, Long> collect5 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(collect5);

        Optional<Map.Entry<Character, Long>> first = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst();
        System.out.println(first);

        LinkedHashMap<Character, Long> collect6 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println(collect6);


        //Map doesn't preserve insertion order in order to preserve we can use LinkedHashMap

    }
}
