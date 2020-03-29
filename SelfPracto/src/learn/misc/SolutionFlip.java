package com.learn.misc;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created By MMT6540 on 15 Jun, 2018
 */
public class SolutionFlip {
    public ArrayList<Integer> flip(String A) {
        char[] binaryInputArray = A.toCharArray();
        boolean consecutiveZeros = true;
        boolean consecutiveOnes = true;
        boolean tentativeStartIndexSet = false;
        boolean startIndexSet = false;
        int tentativeStartIndex = Integer.MAX_VALUE;
        int consecutiveZerosCount = 1;
        int consecutiveOnesCount = 1;
        int countOfOnes = 0;
        int countOfZeros = 0;
        int endIndex =  Integer.MAX_VALUE, startIndex = Integer.MAX_VALUE;
        ArrayList<Integer> listOfStartAndEndIndex = new ArrayList<>();
        if(binaryInputArray.length == 1){
            if(binaryInputArray[0] == '1'){
                return listOfStartAndEndIndex;
            }
        }
        boolean flagForSelection = false, flagForNotSelection = false;
        for(int i = 0; i < binaryInputArray.length; i++){
            if(binaryInputArray[i] == '1'){

                countOfOnes += 1;
                if((countOfOnes >= countOfZeros) && flagForSelection){
                    flagForSelection = false;

                }
                if((countOfOnes > countOfZeros) && !flagForNotSelection ){
                    if(i > 0) {
                        if (binaryInputArray[i - 1] != '1') {
                            endIndex = i - 1;
                            flagForNotSelection = true;
                        }
                    }
                }
            }else{
                if((i == 0 || (countOfZeros < countOfOnes)) && (!flagForSelection)){
                    if((countOfOnes - countOfZeros == 1 || countOfOnes == 0) && !tentativeStartIndexSet && !startIndexSet) {
                        startIndex = i;
                        if(tentativeStartIndexSet){
                            tentativeStartIndexSet = false;
                        }
                        countOfZeros += 1;
                        flagForSelection = true;
                        startIndexSet = true;
                    }if(countOfOnes - countOfZeros > 1){
                        countOfZeros += 1;
                        if(!tentativeStartIndexSet){
                            tentativeStartIndex = i;
                            tentativeStartIndexSet = true;
                            startIndexSet = false;
                        }
                    }
                }else{
                    countOfZeros += 1;
                }

                if(flagForSelection) {
                    endIndex = i;
                    flagForNotSelection = false;
                }
            }
        }
        int newStartIndex = Integer.MAX_VALUE;
        boolean newStartIndexMappedToStartIndex = false;
        if(startIndex != Integer.MAX_VALUE) {
            for (int i = startIndex; i >= 2; i--) {
                if (binaryInputArray[i - 1] == '1' && binaryInputArray[i - 2] == '0') {
                    if (!newStartIndexMappedToStartIndex) {
                        newStartIndex = startIndex - 2;
                        newStartIndexMappedToStartIndex = true;
                    } else {
                        newStartIndex = newStartIndex - 2;
                    }
                    i--;
                } else {
                    break;
                }
            }

        }
        //  Handling the case for all 1s
        if(startIndex == Integer.MAX_VALUE && endIndex == endIndex){

            return listOfStartAndEndIndex;
        }

        if(newStartIndex != Integer.MAX_VALUE){
            listOfStartAndEndIndex.add(newStartIndex+1);
            listOfStartAndEndIndex.add(endIndex+1);
        }else{
            listOfStartAndEndIndex.add(startIndex+1);
            listOfStartAndEndIndex.add(endIndex+1);
        }



        return listOfStartAndEndIndex;
    }


    public static void main(String[] args) {
        SolutionFlip sol = new SolutionFlip();
        sol.flip("0011101");
    }
}