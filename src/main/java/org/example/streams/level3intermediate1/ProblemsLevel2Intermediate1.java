package org.example.streams.level3intermediate1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProblemsLevel2Intermediate1 {
    public static void main(String args[]){

        List<Employee> employees= Arrays.asList(
                new Employee(101,"John","HR",50000),
                new Employee(102,"Alice","IT",70000),
                new Employee(103,"Bob","Finance",45000),
                new Employee(104,"David","HR",90000),
                new Employee(105,"Mike","IT",60000)
        );



//        Sort List Of Employees By Salary
          List<Employee> listAscending=employees.stream()
                  .sorted(Comparator.comparing(Employee::getSalary))
                  .toList();

          System.out.println(listAscending);

        List<Employee> listDecending=employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();

        System.out.println(listDecending);

//      Calculate the average age of a list of Person objects using Java streams

        List<Person> personList= Arrays.asList(
                new Person("Alice",25),
                new Person("Bob",30),
                new Person("Charlie", 28),
                new Person("David", 35)
        );

        double avg = personList.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

         System.out.println(avg);

//        Partition numbers in even and odd list
          List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

          Map<Boolean,List<Integer>> output=numbers.stream()
                  .collect(Collectors.partitioningBy(n->n%2==0));

          System.out.println("Even Numbers :" +output.get(true));

          System.out.println("Odd Numbers :" +output.get(false));

//        Group a list of words by their length using Streams.
          List<String> words= Arrays.asList("apple", "bat", "ball", "cat", "banana", "dog", "goat");

          Map<Integer, List<String>> collect = words.stream()
                .collect(Collectors.groupingBy(String::length));

                System.out.println(collect);

//        Count occurrences of each element in a list
          List<String> word= Arrays.asList("apple", "bat", "bat", "cat", "cat", "cat", "apple", "goat");
        Map<String, Long> collect1 = word.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

              System.out.println(collect1);


//        Group employees by department and calculate average salary
        Map<String, Double> collect2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

    }
}
