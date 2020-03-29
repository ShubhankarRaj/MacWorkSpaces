package com.learn.misc;

import java.util.*;
import java.util.stream.Collectors;

public class SolContiguosArrayRange {

    HashSet<ArrayList<Integer>> listOfSubs = new HashSet<>();
    Boolean setAdditionOfSingle = true;
    static Integer maxRange = Integer.MIN_VALUE;
    static Integer minRange = Integer.MAX_VALUE;

    public int numRange(ArrayList<Integer> A, int B, int C) {
        maxRange = C; minRange = B;
        if(A.size() == 1)
            if (A.get(0) >= B && A.get(0) <= C)
                return 1;
            else
                return 0;

        int countOfContinousSubseq = 0;

        //  Count the number of Duplicates in the Array
        Set<Integer> allItems = new HashSet<>();
        Set<Integer> duplicates = A.stream().filter(n -> !allItems.add(n)).collect(Collectors.toSet());
        int numOfDuplicates = 0;
        for(int dup:duplicates){
            if(dup >= minRange){
                numOfDuplicates ++;
            }
        }
        ArrayList<ArrayList<Integer>> listOfSubSeq = getListOfSubSeq(A, 0, A.size());
        for(ArrayList<Integer> seqList : listOfSubSeq){
            int sum = 0;
            for(Integer seq: seqList){
                sum += seq;
            }
            if(sum >=B && sum <= C)
                countOfContinousSubseq = countOfContinousSubseq+1;
        }
        return countOfContinousSubseq + numOfDuplicates;
    }

    private ArrayList<ArrayList<Integer>> getListOfSubSeq(ArrayList<Integer> list, int startingPoint, int size){
        boolean gotValGreaterThanMaxVal = false;
        while(startingPoint < size){
            int originalSize = size;
            while(originalSize > startingPoint){
                ArrayList<Integer> subs = new ArrayList<>();
                for(int i = startingPoint; i < originalSize; i++){
                    if(list.get(i) > maxRange) {
                        gotValGreaterThanMaxVal = true;
                        break;
                    }
                    if(i < size-1 ) {
                        if (list.get(i) >= minRange && list.get(i) <= maxRange && (list.get(i + 1) <= maxRange))
                            listOfSubs.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{list.get(i)})));
                    }else if(i == (size - 1)){
                        if (list.get(i) >= minRange && list.get(i) <= maxRange)
                            listOfSubs.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{list.get(i)})));
                    }
                    subs.add(list.get(i));
                }
                listOfSubs.add(subs);
                if(gotValGreaterThanMaxVal)
                    break;
                originalSize --;
            }
            startingPoint ++;
        }

        ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>(listOfSubs);
        return returnList;
    }

    public static void main(String[] args) {
        SolContiguosArrayRange sol = new SolContiguosArrayRange();
        ArrayList<Integer> input =  new ArrayList<Integer>(Arrays.asList(new Integer[]{ 61, 71, 69, 97, 40, 6, 57, 70, 13, 70, 21, 46, 21, 71, 49, 83, 84, 71, 97, 13, 80, 50 }));

        System.out.println(sol.numRange(input, 58, 942));
    }
}
