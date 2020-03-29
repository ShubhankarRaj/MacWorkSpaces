package com.hacker.rank.problemsolving;

public class RepeatedString {
    static long repeatedString(String s, long n) {

/*
        long countChar = 0;
        String infiniteStr = "";
        int charCounter = 0;
        for(int i = 0; i < n; i++){

                infiniteStr += s.charAt(charCounter);
                if(s.charAt(charCounter) == 'a')
                    countChar++;

                charCounter++;
                if(charCounter == s.length())
                    charCounter = 0;

            }

        return countChar;


        long size = s.length();
        String orginalString = s;
        String newString = s;
        long countChar = 0;
        int stringCharCounter = 0;
        for(long i = 0; i < (n - size); i++){
            newString += orginalString.charAt(stringCharCounter);
            if(orginalString.charAt(stringCharCounter) == 'a')
                countChar++;

            if(stringCharCounter < orginalString.length()) {
                stringCharCounter++;
                continue;
            }
            else{
                stringCharCounter = 0;
            }

        }


        return countChar;*/


        long rem = n % s.length();
        long quotient = n / s.length();

        long aCounter = 0;
        long aCounterWithinRem = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a') {
                aCounter++;
                if(rem > 0)
                aCounterWithinRem++;
            }
            rem --;
        }


        return (aCounter * quotient + aCounterWithinRem);


    }

    public static void main(String[] args) {
        System.out.println(RepeatedString.repeatedString("aba", 10));
    }
}
