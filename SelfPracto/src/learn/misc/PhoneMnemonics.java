package com.learn.misc;

import java.util.ArrayList;

public class PhoneMnemonics {

    static ArrayList<String> dictionary = new ArrayList<>();

    //  A sample disctionary which contains couple of words
    public static ArrayList<String> listMnemonics(String input) {

        ArrayList<String> list = new ArrayList<>();
        String[] dicnary = {"A", "B", "BALL", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "MAD", "OCD", "PAN", "PCM", "PCO", "RAM", "SAM", "BE", "RAJ"};

        for(String word : dicnary){
            dictionary.add(word);
        }

        listMnemonics("", input, list);
        return list;
    }

    //  Creating the recurive method to list Down all the Mnemonics:
    private static void listMnemonics(String prefix, String remaining, ArrayList<String> list){
        if(remaining.isEmpty()){
            if(!list.contains(prefix) && dictionary.contains(prefix))
                list.add(prefix);
            return;
        }

        if(remaining.charAt(0) == '1' || remaining.charAt(0) == '0'){
            listMnemonics(prefix, remaining.substring(1), list);
        }

        String letters = digitLetters(remaining.charAt(0));
        for(int i = 0; i < letters.length(); i++){
            String newPrefix = prefix + letters.charAt(i);
            String newRemaining = remaining.substring(1);
            listMnemonics(newPrefix, newRemaining, list);
        }
    }

    private static String digitLetters(char ch)
    {
        switch (ch) {
            case '2':
                return "ABC";
            case '3':
                return "DEF";
            case '4':
                return "GHI";
            case '5':
                return "JKL";
            case '6':
                return "MNO";
            case '7':
                return "PQRS";
            case '8':
                return "TUV";
            case '9':
                return "WXYZ";
        }
        return "";
    }

    public static void main(String[] args)
    {
        String str = "2255";
        ArrayList<String> list = listMnemonics(str);
        System.out.println(list);
    }
}
