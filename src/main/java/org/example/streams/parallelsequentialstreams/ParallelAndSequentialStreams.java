package org.example.streams.parallelsequentialstreams;

import java.util.Arrays;

public class ParallelAndSequentialStreams {
    public static void main(String args[]){
        int arr[] = new int[1000000];
        Arrays.fill(arr,2);

        //Calculate sum of squares using sequential stream
        long startTime= System.currentTimeMillis();
        final  int sequentialSum= Arrays.stream(arr)
                .map(n->n*n)
                .sum();
        long endTime= System.currentTimeMillis();
        System.out.println("*****-----  Sequential sum of Factorials ------*****" + " " + sequentialSum);
        System.out.println("*****-----Time Taken by Sequential Stream------*****" + " " + (endTime-startTime) +" ms");

        //Calculate sum od squares using parallel stream
        startTime=System.currentTimeMillis();
        final int parallelSum=Arrays.stream(arr)
                .parallel()
                .map(n->n*n)
                .sum();
        endTime=System.currentTimeMillis();
        System.out.println("*****-----  Sequential sum of Factorials ------*****" + " " + parallelSum);
        System.out.println("*****-----Time Taken by Sequential Stream------*****" + " " + (endTime-startTime) +" ms");

    }
}
