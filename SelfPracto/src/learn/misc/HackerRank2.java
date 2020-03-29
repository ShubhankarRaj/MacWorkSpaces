package com.learn.misc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HackerRank2 {

    public static String rollString(String s, List<Integer> roll){
        char[] arrayOfCharacters = s.toCharArray();

        Iterator<Integer> rollItr = roll.iterator();
        int index = 0;
        while(rollItr.hasNext()){
            if(index == 0) {
                index++;
                continue;

            }
            arrayOfCharacters = rollChars(arrayOfCharacters, rollItr.next());
        }

        return new String(arrayOfCharacters);
    }

    private static char[] rollChars(char[] inputCharArr, int rangeToRoll){
        for(int i=0; i <= rangeToRoll-1; i++){
            int asciiEqui = (int) inputCharArr[i];

            if(asciiEqui == 122)
                asciiEqui = 97;
            else
                asciiEqui++;
            inputCharArr[i] = (char) (asciiEqui);
        }

        return inputCharArr;
    }

    public static void main(String[] args){
        HackerRank2 hc = new HackerRank2();
        String input = "ayz";
        List<Integer> rollOver = new ArrayList<>();
        rollOver.add(1);
        rollOver.add(3);
        //rollOver.add(1);
        //rollOver.add(2);
        HackerRank2.rollString(input, rollOver);
    }
}
