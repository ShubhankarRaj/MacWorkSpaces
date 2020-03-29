package learn.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    static ArrayList<ArrayList<Integer>> retArrList = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Integer[] subset = new Integer[A.size()];
        Collections.sort(A);
        getAllCombinations(A, subset, 0);

        return retArrList;
    }

    private static void getAllCombinations(ArrayList<Integer> arr, Integer[] sub, int i){
        if(i == arr.size()){
            List<Integer> newList = new ArrayList<>();
            for(Integer num : sub){
                if(num != null)
                    newList.add(num);
            }

            //Collections.sort(newList);
            retArrList.add((ArrayList<Integer>) newList);
            return;
        }
        else{
            sub[i] = null;
            getAllCombinations(arr, sub, i+1);
            sub[i] = arr.get(i);
            getAllCombinations(arr, sub, i+1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(12, 13));
        Solution1 sol = new Solution1();
        System.out.println(sol.subsets(input));
    }
}
