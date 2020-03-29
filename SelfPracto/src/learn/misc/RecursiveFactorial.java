package com.learn.misc;

public class RecursiveFactorial {
    public static void main(String[] args) {
        int input = 5;
        int factorial = factorial(input);
        System.out.println("The Factorial for "+input+" is: "+factorial);
    }

    private static int factorial(int input) {
        if(input == 1){
            return input;
        }else{
            return input*factorial(input - 1);
        }
    }

}
