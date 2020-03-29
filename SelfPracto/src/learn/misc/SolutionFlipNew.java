package com.learn.misc;

import java.util.ArrayList;

/**
 * Created By MMT6540 on 16 Jun, 2018
 */
public class SolutionFlipNew {
    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> flipIndexes = new ArrayList<>();
        int sum = 0, start = 0, end = 0, maxSum = Integer.MIN_VALUE, maxStart = Integer.MIN_VALUE, maxEnd = Integer.MIN_VALUE;
        boolean recurringOne = false, recurringZero = false;
        char[] binaryInputArray = A.toCharArray();
        int size = binaryInputArray.length;
        if(size == 1){
            if(binaryInputArray[0] == '1'){
                return flipIndexes;
            }
        }
        for(int i=0; i < size; i++){
            if(binaryInputArray[i] == '1' && !recurringOne){
                if(sum == 0){
                    sum = 0;
                }else{
                    sum -= 1;
                }
                recurringOne = true;
                recurringZero = false;
            }
            else if(binaryInputArray[i] == '1' && recurringOne){
                if(sum == 0){
                    sum = 0;
                }else{
                    sum -= 1;
                }
            }
            else if(binaryInputArray[i] == '0' && !recurringZero){
                sum = sum + 1;
                start = i;
                end = i;
                if(sum > maxSum){
                    maxSum = sum;
                    maxStart = start;
                    maxEnd = end;
                }
                else if(sum == maxSum){

                        int countNumOfOnes = 0, countNumOfZeros = 0;
                        for (int j = maxStart; j <= i; j++) {
                            if (binaryInputArray[j] == '0')
                                countNumOfZeros++;
                            else
                                countNumOfOnes++;
                        }

                        if(countNumOfZeros > countNumOfOnes) {
                            if ((countNumOfZeros % 2 == 0) && (i + 1 < size)) {
                                if (binaryInputArray[i + 1] == '1')
                                    maxEnd = maxStart;
                            }
                            if ((countNumOfZeros % 2 == 1) && (i + 1 < size)) {
                                if (binaryInputArray[i + 1] == '0')
                                    maxEnd = end;
                            }
                        }else if(countNumOfZeros < countNumOfOnes){
                            if(countNumOfOnes > sum) {
                                maxStart = start;
                                maxEnd = end;
                            }
                        }
                }
                recurringZero = true;
                recurringOne = false;
            }
            else if(binaryInputArray[i] == '0' && recurringZero){
                sum += 1;
                end = i;
                if(sum > maxSum){
                    maxSum = sum;
                    maxEnd = end;
                }
            }
        }
        if(maxStart != Integer.MIN_VALUE)
            flipIndexes.add(maxStart+1);
        if(maxEnd != Integer.MIN_VALUE)
            flipIndexes.add(maxEnd+1);
        return flipIndexes;
    }

    public static void main(String[] args) {
        SolutionFlipNew sol = new SolutionFlipNew();
        sol.flip("0111000100010");
        sol.flip("01010110");
        sol.flip("01110101011111");
    }
}