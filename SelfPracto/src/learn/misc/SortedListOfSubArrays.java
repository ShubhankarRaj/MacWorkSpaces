package com.learn.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortedListOfSubArrays {

    ArrayList<ArrayList<Integer>> combos = new ArrayList<>();
    HashMap<ArrayList<Integer>, ArrayList<Integer>> comboMap = new HashMap<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> subset = new ArrayList<>();
        Collections.sort(A);

        getAllCombinations(A, subset, 0);
        return combos;
    }

    public void getAllCombinations(ArrayList<Integer> arr, ArrayList<Integer> subset, int i){
        if (i == arr.size()) {
            ArrayList<Integer> combinations;
            combinations = subset;
            comboMap.put(combinations, combinations);
            return;
        } else {
            subset.add(i, null);
            getAllCombinations(arr, subset, i + 1);
            if(subset.get(i) == null)
                subset.remove(i);
            subset.add(i, arr.get(i));
            getAllCombinations(arr, subset, i + 1);
        }
    }

    public static void main(String[] args) {
        SortedListOfSubArrays sol = new SortedListOfSubArrays();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1); input.add(3); /*input.add(5); input.add(6);*/
        sol.subsets(input);
    }
}
