package com.learn.code.jam.practise;


import java.util.Scanner;

public class GuessYourNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countOfTestCases = in.nextInt();
        for(int i = 1; i <= countOfTestCases; ++i){

            int startRange = in.nextInt();
            int endRange = in.nextInt();

            int totalGuessesAllowed = in.nextInt();
            int totalTries = 0;
            while(totalTries < totalGuessesAllowed){
                System.out.println((startRange+endRange)/2);
                String inputFromJudge = in.next();

                if(inputFromJudge.contains("CORRECT")){
                    break;
                }
                else if(inputFromJudge.equals("TOO_SMALL")){
                    startRange = ((startRange+1)+endRange)/2;
                }
                else{
                    endRange = (startRange+endRange)/2;
                }
                totalTries++;
            }

        }

    }
}
