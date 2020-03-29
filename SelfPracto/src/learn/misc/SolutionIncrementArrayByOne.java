package com.learn.misc;

import java.util.ArrayList;

/**
 * Created By MMT6540 on 12 Jun, 2018
 */
public class SolutionIncrementArrayByOne {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carryForward = 0;
        int counterForAList = 0;

        ArrayList<Integer> ANew = new ArrayList<>();
        int index = 0;
        if(A.get(index) == 0 && A.size() > 1){
            int theRealSize = 0;
            while(A.get(index) == 0){
                index = index+1;
            }
            theRealSize = A.size() - (index);
            while(theRealSize > 0){
                ANew.add(A.get(A.size() - theRealSize));
                theRealSize-- ;
            }
        }else{
            ANew = A;
        }
        int size = ANew.size();
        for(int i = ANew.size()-1; i >= 0; i--){
            if(i == 0){
                if(ANew.get(i) == 9 && carryForward == 1){
                    ANew.set(i,0);
                    ArrayList<Integer> B = new ArrayList<>();
                    B.add(1);
                    while(size > 0){
                        B.add(ANew.get(counterForAList));
                        counterForAList++;
                        size--;
                    }
                    return B;
                }else if(ANew.get(i) == 9 && carryForward == 0 && ANew.size() == 1){
                    ANew.set(0,1);
                    ANew.add(1,0);
                }else if(ANew.size() == 1 || carryForward == 1){
                    ANew.set(i, ANew.get(i) + 1);
                }

            }
            else if(i == ANew.size() - 1){
                if (ANew.get(i) == 9) {
                    ANew.set(i, 0);
                    carryForward = 1;
                }else{
                    ANew.set(i, ANew.get(i)+1);
                }
            }
            else{
                if((carryForward == 1) && (ANew.get(i) != 9)){
                    ANew.set(i, ANew.get(i)+1);
                    carryForward = 0;
                }
                else if((carryForward == 1) && (ANew.get(i) == 9)){
                    ANew.set(i, 0);
                    carryForward = 1;
                }
            }
        }
        return ANew;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inputArr = new ArrayList<>();

        inputArr.add(0);
        inputArr.add(0);
        inputArr.add(1);
        inputArr.add(3);
        inputArr.add(4);
        inputArr.add(5);
        inputArr.add(9);
        /*inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);
        inputArr.add(9);*/
        SolutionIncrementArrayByOne newSol = new SolutionIncrementArrayByOne();
        newSol.plusOne(inputArr);
    }
}