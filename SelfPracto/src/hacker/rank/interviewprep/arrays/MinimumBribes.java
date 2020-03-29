package com.hacker.rank.interviewprep.arrays;

public class MinimumBribes {
    static void minimumBribes(int[] q) {

        int brbeCount = 0;
        for(int i = 0; i < q.length; i++){
            int difference = (i+1) - q[i];
            if(difference < 0)
                difference *= -1;

            if(difference > 2){
                System.out.println("Too chaotic");
                break;
            }else{
                if(difference == 0)
                    continue;
                /*else if()*/
            }
         }
    }

}
