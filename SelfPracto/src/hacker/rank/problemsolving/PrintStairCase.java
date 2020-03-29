package com.hacker.rank.problemsolving;

public class PrintStairCase {
    static void staircase(int n) {

        int stairCounter = n-1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j >= stairCounter)
                    System.out.print("#");
                else
                    System.out.print(" ");

            }
            stairCounter--;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintStairCase.staircase(6);
    }
}
