package com.learn.misc;

import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        word = word.toUpperCase();
        char[] charArry = word.toCharArray();
        for(int i = 0; i < charArry.length/2; i++){
            if(charArry[i] != charArry[(charArry.length - 1) - i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String word = reader.nextLine();
        System.out.println(isPalindrome(word));
    }
}
