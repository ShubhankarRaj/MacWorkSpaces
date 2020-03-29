package com.learn.misc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created By MMT6540 on 12 Jun, 2018
 */
public class FindAllFactorsSolution {
    public ArrayList<Integer> allFactors(int A) {
        ArrayList arrayOfFactors = new ArrayList();
        if( A == 0 ){
            arrayOfFactors.add(0);
            return arrayOfFactors;
        }
        if (A == 1){
            arrayOfFactors.add(1);
            return arrayOfFactors;
        }

        for(int i = 1; i <= A/2; i++){
            if(A%i == 0){
                arrayOfFactors.add(i);
            }
        }
        arrayOfFactors.add(A);
        return arrayOfFactors;
    }

    public ArrayList<Integer> allFactorsNew(int a) {
        int upperlimit = (int)(Math.sqrt(a));
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for(int i=1;i <= upperlimit; i+= 1){
            if(a%i == 0){
                factors.add(i);
                if(i != a/i){
                    factors.add(a/i);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }

    public static void main(String[] args) {
        FindAllFactorsSolution fac = new FindAllFactorsSolution();
        fac.allFactors(10);
        fac.allFactorsNew(20);
    }
}