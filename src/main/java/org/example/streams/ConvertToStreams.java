package org.example.streams;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertToStreams {
    public static void main(String args[]){
        int primitiveArr[]={1,2,3,4,5,6};

        IntStream intStream= Arrays.stream(primitiveArr);
         intStream.forEach(System.out::println);

         Integer wrapperArr[] ={1,2,3,4,5};
        Stream<Integer> list= Arrays.stream(wrapperArr);
        list.forEach(System.out::println);

        List<Integer> collection= Arrays.asList(1,2,3,4,5,6);
        collection.stream().forEach(System.out::println);


    }
}
