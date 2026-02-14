package org.example.streams.level6hard2;

import org.example.streams.level3intermediate1.Employee;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProgramLevelHard2 {
    public static  void main(String args[]){


        List<Transaction> transactions= Arrays.asList(
                new Transaction("T1", LocalDate.of(2024,1,1),300),
                new Transaction("T2",LocalDate.of(2024,1,1),200),
                new Transaction("T3", LocalDate.of(2024,1,2),500),
                new Transaction("T4",LocalDate.of(2024,1,2),300),
                new Transaction("T5",LocalDate.of(2024,1,3),100)
        );

//**From a List of Transactions, Find the Day With the Highest Total Spend**
        Map<LocalDate, List<Transaction>> collect = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getDate));

        System.out.println(collect );

        Map<LocalDate, Double> collect1 = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getDate,
                        Collectors.summingDouble(Transaction::getAmount)
                ));
        System.out.println(collect1);

        Map.Entry<LocalDate, Double> localDateDoubleEntry = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getDate,
                        Collectors.summingDouble(Transaction::getAmount)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();
        System.out.println(localDateDoubleEntry);


//**Categorize employees based on their salary (Low / Medium / High) using Streams.**
        List<Employee> employees= Arrays.asList(
                new Employee(1,"John","HR",50000),
                new Employee(2,"Alice","IT",70000),
                new Employee(3,"Bob","Finance",45000),
                new Employee(4,"David","IT",12000),
                new Employee(5,"Mike","IT",60000),
                new Employee(6,"Jane","HR",165000)
        );


        Map<SalaryRange, List<Employee>> collect2 = employees.stream()
                .collect(Collectors.groupingBy(
                        e-> getSalaryRange(e.getSalary())
                ));

        System.out.println((collect2));
//**Group Characters by Uppercase vs Lowercase vs Digit vs Other**
        List<Character> chars= Arrays.asList(
                'A','b','3','Z','x','#','7','m','@'
        );
        Map<Object, List<Character>> collect3 = chars.stream()
                .collect(Collectors.groupingBy(
                        ch -> getCharCategory(ch.charValue())
                ));
System.out.println(collect3);

//**Find All Employees Who Worked in 3+ Departments**
        List<WorkRecord> records = Arrays.asList(
                new WorkRecord("John", "IT"),
                new WorkRecord("John", "Finance"),
                new WorkRecord("John","HR"),
                new WorkRecord("Alice","IT"),
                new WorkRecord("Alice","HR"),
                new WorkRecord("David","Finance"),
                new WorkRecord("David","Finance"),
                new WorkRecord("David","IT"),
                new WorkRecord("David","Finance"),
                new WorkRecord("David","HR"),
                new WorkRecord("David","Admin")
                );

        Map<String, List<WorkRecord>> collect4 = records.stream()
                .collect(Collectors.groupingBy(
                        WorkRecord::getEmployeeName
                ));

        System.out.println(collect4);

        List<String> list = collect4.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 3)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(list);
//**Find Bigram Frequencies (Pairs of Consecutive Words) in Paragraphs**
     String paragraph="Java is great and Java is fun. Java is powerful!";
     



    }

    private static SalaryRange getSalaryRange(Double salary) {
        if (salary < 50000) return SalaryRange.LOW;
        if (salary < 100000) return SalaryRange.MEDIUM;
        else return SalaryRange.HIGH;
    }

    private static Object getCharCategory(char c){
        if(Character.isUpperCase(c)) return CharCategory.UPPERCASE;
        if(Character.isLowerCase(c)) return CharCategory.LOWERCASE;
        if(Character.isDigit(c)) return CharCategory.DIGIT;
        return CharCategory.OTHER;

    }
}
