package com.learn.misc;

import java.util.ArrayList;
import java.util.Arrays;

public class SolContigousArrayRangeNew {

    ArrayList<Integer> arrOfSumsInRange = new ArrayList<>();
    public int numRange(ArrayList<Integer> A, int B, int C) {

        if(A.size() == 1)
            if (A.get(0) >= B && A.get(0) <= C)
                return 1;
            else
                return 0;

        for(int i = 0; i < A.size()-1; i++){
            if(A.get(i) >= B && A.get(i) <= C) {
                arrOfSumsInRange.add(A.get(i));
            }
            int j = i+1;
            if (A.get(i) > C) {
                if(i==A.size()-2 && (A.get(j) >= B && A.get(j) <= C))
                    arrOfSumsInRange.add(A.get(j));
                continue;
            }
            int sum = A.get(i);
            for(j = i+1; j < A.size(); j++){
                if ((i==A.size()-2) && (j == (A.size() - 1)) && (A.get(j) >= B && A.get(j) <= C))
                    arrOfSumsInRange.add(A.get(j));
                sum += A.get(j);
                if(sum > C)
                    break;
                else {
                    if(sum >= B && sum <= C)
                        arrOfSumsInRange.add(sum);
                }
            }
        }

        return arrOfSumsInRange.size();
    }

    public static void main(String[] args) {
        SolContigousArrayRangeNew sol = new SolContigousArrayRangeNew();
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(new Integer[]{89, 5, 29, 71, 43, 28, 79, 63, 98, 42, 1, 46, 79, 41}));
        System.out.println(sol.numRange(input, 14, 55));
    }
}
