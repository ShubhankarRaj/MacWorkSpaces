package com.learn.misc;

/**
 * Created By MMT6540 on 18 Jun, 2018
 */
public class SolutionTrailingZeros {
    public int trailingZeroes(int A) {
        double numWhichGensZeros = 5;
        double powerToWhichRaised = 1;
        int numOfTrailingZeros = 0;
        int quotient = 5;

        while(quotient > 0){
            numWhichGensZeros = Math.pow(numWhichGensZeros, powerToWhichRaised);
            quotient = A/((int)numWhichGensZeros);
            numOfTrailingZeros = numOfTrailingZeros + quotient;
            powerToWhichRaised = powerToWhichRaised + 1;
            numWhichGensZeros = 5;
        }
        return numOfTrailingZeros;
    }

    public static void main(String[] args) {
        SolutionTrailingZeros sol = new SolutionTrailingZeros();
        sol.trailingZeroes(9247);
    }
}