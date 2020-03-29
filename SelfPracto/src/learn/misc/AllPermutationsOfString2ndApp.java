package com.learn.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsOfString2ndApp {
    public static void main(String args[]) {
        //permutation("1234");
        ArrayList<Integer> newList = new ArrayList<>();
        //newList.add(8);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        AllPermutationsOfString2ndApp sol = new AllPermutationsOfString2ndApp();
        ArrayList<ArrayList<Integer>> result = sol.permute(newList);
    }


    /*
     * A method exposed to client to calculate permutation of String in Java.
     */
    public static void permutation(String input){
        permutation("", input);
    }

    /*
     * Recursive method which actually prints all permutations
     * of given String, but since we are passing an empty String
     * as current permutation to start with,
     * I have made this method private and didn't exposed it to client.
     */

    static Set<ArrayList<Integer>> setOfLists = new HashSet<>();
    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            //System.err.println(perm + word);
            String res = perm + word;
            String[] str = res.split("(?=\\d)");
            List<Integer> list = new ArrayList<>();
            for(String strng : str){
                list.add(Integer.parseInt(strng));
            }
            //System.out.println(list.toString());
            setOfLists.add((ArrayList<Integer>) list);

        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }

    }



















    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        if(A.size() == 1){
            ArrayList<ArrayList<Integer>> resultSingleArr = new ArrayList<ArrayList<Integer>>();
            resultSingleArr.add(A);
            return resultSingleArr;
        }
        String input = A.toString().replace("[", "").replace("]", "").replace(",","").replace(" ","");
        permutation("", input);
        ArrayList<ArrayList<Integer>> resultArr = new ArrayList<ArrayList<Integer>>(setOfLists);
        System.out.println(resultArr.toString());
        return resultArr;
    }



}


