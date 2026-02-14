package org.example.streams.level1supereasy;

import java.util.Arrays;
import java.util.List;

public class CreateStreams {
    public static void main(String args[]){
        List<Integer> listofIntegers= Arrays.asList(1,2,3,4,5,6,7,8,9);
        listofIntegers.stream().forEach(System.out::println);
    }
}
