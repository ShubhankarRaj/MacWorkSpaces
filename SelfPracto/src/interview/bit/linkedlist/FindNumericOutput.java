package com.interview.bit.linkedlist;

public class FindNumericOutput {

    /*static int findPossibleSmallestNumberMatchingPattern(String pattern){
        if(pattern.equals("") || pattern.equals(null) || pattern.equals(" "))
            return -1;

        if(!pattern.matches("[MN]+"))
            return -1;

        char[] arrCh = pattern.toCharArray();

        Integer[] arrInt = new Integer[pattern.length() + 1];

        int len = arrCh.length;
        int i = 0;
        while(len > 0){
            if(arrCh[i] == 'N'){
                if(i == 0)
                    arrInt[i] = 1;
                else
                    arrInt[i+1] = arrInt[i] + 1;
            }

        }
    }*/
}


//  N - Ascending
//  M - Descending
//  NNM = 1243
//  MMN = 3214 MMNN = 32145 MMNM = 43251
//  NNNNNNNNM = 12345687