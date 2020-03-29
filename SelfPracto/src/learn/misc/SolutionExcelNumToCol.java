package com.learn.misc;

import java.util.HashMap;

/**
 * Created By MMT6540 on 20 Jun, 2018
 */
public class SolutionExcelNumToCol {
    public String convertToTitle(int A) {
        int divisor = 26;
        int remainder = Integer.MAX_VALUE;
        int quotient = A;

        HashMap<Integer, Character> characterMap = new HashMap<>();
        char firstMapChar = 'A';
        int columnNum = 1;
        int asciiEquiv = (int) firstMapChar;
        for (int i = asciiEquiv; i < asciiEquiv + 26; i++) {
            characterMap.put(columnNum, (char) i);
            columnNum++;
        }
        String colTitle = "";
        String quotientString = "";
        int carryForward = 0;

        while(quotient >= 1){
            if(quotient == 1 && remainder == 0){
                break;
            }
            remainder = quotient % divisor;
            if(remainder != 0) {
                remainder = remainder - carryForward;
                if(remainder !=0) {
                    colTitle = characterMap.get(remainder) + colTitle;
                    carryForward = 0;
                }
                else {
                    colTitle = characterMap.get(26) + colTitle;
                    carryForward = 1;
                }

            }
            else if(remainder == 0 && carryForward != 0){
                colTitle = characterMap.get(25) + colTitle;
                carryForward = 1;
            }
            else {
                colTitle = characterMap.get(26) + colTitle;

                carryForward = carryForward + 1;
            }
            //quotientString = quotientString + Integer.toString(remainder);
            quotient = quotient / divisor;
        }

        return colTitle;
    }

    public static void main(String[] args) {
        SolutionExcelNumToCol sol = new SolutionExcelNumToCol();
        sol.convertToTitle(140627);
        sol.convertToTitle(1);
        sol.convertToTitle(838674);
        sol.convertToTitle(468096);
        sol.convertToTitle(475254);
        sol.convertToTitle(702);
        sol.convertToTitle(943566);
        sol.convertToTitle(980089);

    }
}