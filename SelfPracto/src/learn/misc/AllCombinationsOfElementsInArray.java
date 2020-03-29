package com.learn.misc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created By MMT6540 on 27 Apr, 2018
 */
public class AllCombinationsOfElementsInArray {

    public static void main(String args[]){
        Integer[] arr = {12,39};
        Integer[] subset = new Integer[arr.length];
        getAllCombinationAndPrint(arr, subset, 0);
    }

    private static void getAllCombinationAndPrint(Integer[] arr, Integer[] subset, int i) {
        if (i == arr.length) {
            printArray(subset);
            return;
        } else {
            subset[i] = null;
            getAllCombinationAndPrint(arr, subset, i + 1);
            subset[i] = arr[i];
            getAllCombinationAndPrint(arr, subset, i + 1);
        }
    }

    private static void printArray(Integer[] arrToPrint) {
        for (int i = 0; i < arrToPrint.length; i++) {
            if (arrToPrint[i] != null) {
                System.out.print(arrToPrint[i] + ",");
            }
        }
        System.out.println();
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        return null;
    }
}