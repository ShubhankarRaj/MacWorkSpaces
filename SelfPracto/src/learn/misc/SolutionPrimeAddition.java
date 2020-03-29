package com.learn.misc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created By MMT6540 on 13 Jun, 2018
 */
public class SolutionPrimeAddition {
    public ArrayList<Integer> primesum(int A) {
        //  Expected A is greater than 2, like 4, 6, 8, etc.
        //  Prime numbers start with 2
        int firstAddend = 0;
        int secAddend = 0;
        ArrayList<ArrayList<Integer>> listOfIntegerPairs = new ArrayList<>();
        ArrayList<Integer> listToReturn = new ArrayList<>();
        SolutionPrimeAddition sol = new SolutionPrimeAddition();
        for(int i = 2; i <= A/2; i++){
            firstAddend = i;
            secAddend = A - i;
            if( sol.isPrime(firstAddend) && sol.isPrime(secAddend)){
                listOfIntegerPairs.add(new ArrayList<>(Arrays.asList(firstAddend, secAddend)));
                listToReturn.add(firstAddend);
                listToReturn.add(secAddend);
                return listToReturn;
            }
        }
        return listToReturn;
    }

    boolean isPrime(int numToCheck){
        for (int i = 2; i <= (int)Math.sqrt(numToCheck); i++){
            if(numToCheck % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolutionPrimeAddition sol = new SolutionPrimeAddition();
        sol.primesum(16777214);
    }
}