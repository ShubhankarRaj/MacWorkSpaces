package com.hacker.rank.problemsolving;

public class PlusMinus {

    static void plusMinus(int[] arr) {

        float divisor = arr.length;
        float positiveC=0;
        float negativeC=0;
        float zeroC=0;

        for(int entry : arr){
            if(entry > 0)
                positiveC++;
            else if(entry < 0)
                negativeC++;
            else
                zeroC++;
        }
        System.out.println(positiveC/divisor);
        System.out.println(negativeC/divisor);
        System.out.println(zeroC/divisor);

    }
}
