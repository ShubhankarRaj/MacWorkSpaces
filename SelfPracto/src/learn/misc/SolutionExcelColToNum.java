package com.learn.misc;

import java.util.HashMap;

/**
 * Created By MMT6540 on 20 Jun, 2018
 */
public class SolutionExcelColToNum {
    public int titleToNumber(String A) {
        char[] charArr = A.toCharArray();
        HashMap<Character, Integer> characterMap = new HashMap<>();
        char firstMapChar = 'A';
        int columnNum = 1;
        int asciiEquiv = (int) firstMapChar;
        for (int i = asciiEquiv; i < asciiEquiv + 26; i++) {
            characterMap.put((char) i, columnNum);
            columnNum++;
        }

        int columnEquivForGivenString = 0;
        int baseColEquivalent;
        double baseSystemForChars = 26;
        for (int i = 0; i < charArr.length; i++) {
            baseColEquivalent = characterMap.get(charArr[charArr.length-1-i]);
            columnEquivForGivenString = columnEquivForGivenString + baseColEquivalent * (int) Math.pow(baseSystemForChars, new Double(i));
        }
        return columnEquivForGivenString;
    }

    public static void main(String[] args) {
        SolutionExcelColToNum sol = new SolutionExcelColToNum();
        sol.titleToNumber("ZPKR");
    }
}