package com.hacker.rank.interviewprep.arrays;

public class PrimeSumArrayProblem {

    static long arrayManipulation(int n, int[][] queries) {

        long[] arr = new long[n];

        for(int[] query: queries){
            arr[query[0] - 1] += query[2];
            arr[query[1]] -= query[2];
        }

        long highest = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i < (arr.length - 1); i++){
            sum += arr[i];
            if(sum > highest)
                highest = sum;
        }

        return highest;
    }

}
