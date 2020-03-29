package com.hacker.rank.interviewprep.arrays;

public class MinimumSwap {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        Boolean notSorted = true;
        int countOfSwaps = 0;

        int startIndexToStartSorting = 0;
        int temp;
        int searchIndexToSwap = 0;
        Boolean newSearchIndexToBeFound = true;

        while(notSorted){

            //  Each index is supposed to have a value greater than itself by 1
            for(int i=startIndexToStartSorting; i < arr.length; i++){
                if(arr[i] !=  i+1){

                    //  Simplest Swap - Interchanging the values to get the right value at right lower index
                    if(arr[arr[i] - 1] == i+1){
                        temp = arr[arr[i] - 1];
                        arr[arr[i] - 1] = arr[i];
                        arr[i] = temp;
                        countOfSwaps++;
                        startIndexToStartSorting = i+1;
                        newSearchIndexToBeFound = true;
                        break;

                    }

                    //  Search for the right value and Swap
                    if(newSearchIndexToBeFound) {
                        searchIndexToSwap = i;
                        newSearchIndexToBeFound = false;
                    }

                    if(searchIndexToSwap < i && arr[i] == searchIndexToSwap + 1){
                        newSearchIndexToBeFound = true;
                        temp = arr[searchIndexToSwap];
                        arr[searchIndexToSwap] = arr[i];
                        arr[i] = temp;
                        countOfSwaps++;
                        startIndexToStartSorting = searchIndexToSwap + 1;
                        break;
                    }

                }else{

                    if(i == arr.length - 1){
                        notSorted = false;
                    }
                }
            }
        }

        return countOfSwaps;

    }

    public static void main(String[] args) {
        //int[] arr = {4,3,1,2};
        //System.out.println(MinimumSwap.minimumSwaps(arr));

        int[] arr1 = {2,3,4,1,5};
        System.out.println(MinimumSwap.minimumSwaps(arr1));
    }
}
