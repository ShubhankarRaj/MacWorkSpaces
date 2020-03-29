package com.hacker.rank.interviewprep.arrays;

public class MinimumSwapSecSol {

    static int minimumSwaps(int[] arr) {
        int swapCount = 0;

        /*
        This solution is O(n) time complexity, where we iterate through the loop only once.
        At a particular position we keep on swapping until the correct number is not found which belongs at that index
         */
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != i+1){
                while(arr[i] != i+1) {
                    int temp = arr[arr[i] - 1];
                    arr[arr[i]-1] = arr[i];
                    arr[i] = temp;
                    swapCount++;
                }
            }
        }

        return swapCount;
    }
}
