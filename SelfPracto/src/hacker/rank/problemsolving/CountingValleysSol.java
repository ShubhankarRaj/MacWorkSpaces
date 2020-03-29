package com.hacker.rank.problemsolving;

public class CountingValleysSol {

    static int countingValleys(int n, String s) {

        int numberOfVallyes = 0;
        boolean ignoreThePeak = false;
        int counter = 0;
        char[] steps = s.toCharArray();
        boolean climbing = false;
        boolean descending = false;

        //  Valley starts with going down and coming up
        int j = 0;
        for(int i = 0; i < steps.length; i ++){
            if(steps[i] == 'U')
                j = 1;
            else
                j = -1;



            if(counter == 0 && j == 1 ){
                //  We are climbing the mountain
                ignoreThePeak = true;
            }

            if(counter == 0 && j == -1){
                //  We have climbed down the mountain
                ignoreThePeak = false;
            }

            if(counter == 0 && !ignoreThePeak){
                numberOfVallyes += 1;
            }

            counter += j;


           /* if(i == 0 && j == 1){
                climbing = true;
            } else{
                descending = true;
            }

            if(climbing && j == 1)
                climbing = true;
            if(climbing && j == -1)
                descending = true;
*/


        }

        return numberOfVallyes;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(4, "UDUD"));
    }
}
