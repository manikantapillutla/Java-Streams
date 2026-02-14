package org.example.streams.parallelsequentialstreams;

import java.util.Arrays;
import java.util.stream.LongStream;

public class FactorialParallelAndSequential {
    public static void main(String args[]){
        long longArray[]= new long[2000];
        for (int i=0;i<2000;i++){
            longArray[i]=i+1;
        }

        //calculate sum of factorials using sequential stream
        long startTime = System.currentTimeMillis();
        long sequentialSum= Arrays.stream(longArray)
                .map(FactorialParallelAndSequential::factorial)
                .sum();
        long endTime= System.currentTimeMillis();
        System.out.println("*****-----  Sequential sum of Factorials ------*****" + " " + sequentialSum);
        System.out.println("*****-----Time Taken by Sequential Stream------*****" + " " + (endTime-startTime) +" ms");

        //calculate sum of factorials using parallel streams
        startTime=System.currentTimeMillis();
        long parallelSum=Arrays.stream(longArray)
                .parallel()
                .map(FactorialParallelAndSequential::factorial)
                .sum();
        endTime=System.currentTimeMillis();
        System.out.println("*****-----  Sequential sum of Factorials ------*****" + " " + parallelSum);
        System.out.println("*****-----Time Taken by Sequential Stream------*****" + " " + (endTime-startTime) +" ms");




    }

    public static long factorial(long number){
        return LongStream.rangeClosed(1,number)
                .reduce(1,(long a, long b)-> a*b);
    }
}
