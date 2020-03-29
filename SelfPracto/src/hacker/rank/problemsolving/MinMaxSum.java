package com.hacker.rank.problemsolving;

import java.math.BigInteger;

public class MinMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        BigInteger highest = new BigInteger("0");
        BigInteger lowest = new BigInteger("0");

        BigInteger totSum = new BigInteger("0");
        for(int i =0; i < arr.length; i++){
            if(i == 0){
                highest = BigInteger.valueOf(arr[i]);
                lowest = BigInteger.valueOf(arr[i]);
            }
            else{
                highest = highest.max(BigInteger.valueOf(arr[i]));
                lowest = lowest.min(BigInteger.valueOf(arr[i]));
            }
            totSum = totSum.add(BigInteger.valueOf(arr[i]));
        }

        System.out.println((totSum.subtract(lowest))+" "+(totSum.subtract(highest)));

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        miniMaxSum(arr);
    }
}
