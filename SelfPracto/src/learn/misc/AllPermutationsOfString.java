package com.learn.misc;

public class AllPermutationsOfString {
    public static void main(String[] args) {
        String input = "123";
        stringPermutations(input, 0, input.length()-1);
    }

    private static void stringPermutations(String input, int left, int right) {
        if(left == right){
            System.out.println(input);
            return;
        }else{
            for(int i = left; i <= right; i++){
                // Swapping the characters of the String
                char[] chars = input.toCharArray();
                char temp = chars[left];
                chars[left] = chars[i];
                chars[i] = temp;
                input = new String(chars);

                stringPermutations(input, left+1, right);

                // Swapping the characters of the String for Backtracking
                chars = input.toCharArray();
                temp = chars[left];
                chars[left] = chars[i];
                chars[i] = temp;
                input = new String(chars);
            }
        }


    }
}
