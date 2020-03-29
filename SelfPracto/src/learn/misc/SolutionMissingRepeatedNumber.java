package com.learn.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By MMT6540 on 16 Jun, 2018
 */
public class SolutionMissingRepeatedNumber {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {

        //long size = .size();
        long sum = 0;
        long size = A.size();
        long sumOfSquares = 0; long i;
        for(i = 0; i < size; i++){
            sum = sum + i+1;
            sumOfSquares = sumOfSquares + (i+1)*(i+1);
        }

        long diffSum = sum;
        long diffSquare = sumOfSquares;


        for (Integer a:A) {
            long aa = (long)a;
            diffSum = (long)diffSum - aa;
            diffSquare = (long)diffSquare - (aa*aa);
        }

        int missngNum = 0, repNum = 0;
        missngNum = (int)((diffSum + (diffSquare / diffSum))/2);
        repNum = (int)(missngNum - diffSum);

        ArrayList returnList = new ArrayList();
        returnList.add(Math.abs(repNum));
        returnList.add(Math.abs(missngNum));

        return returnList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        SolutionMissingRepeatedNumber sol = new SolutionMissingRepeatedNumber();
        for(int i=0; i<365000; i++){
            input.add(i+1);
        }
        System.out.println(input.get(529));
        input.set(529, 721);
        System.out.println(input.get(529));

        sol.repeatedNumber(input);
    }
}