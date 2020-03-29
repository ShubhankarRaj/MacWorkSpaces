package com.hacker.rank.interviewprep.arrays;

public class HourGlassSum {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        Integer maxSum = Integer.MIN_VALUE;
        int rows = arr.length;
        int cols = arr[0].length;
        int sum = 0;
        for(int i = 1; i < rows-1; i++){
            for(int j = 1; j < cols-1; j++){
                sum = 0;
                sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j]+ arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
                if(sum > maxSum) {
                    System.out.println("SUM: "+sum);
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,9,2,-4,-4,0},{0,0,0,-2,0,0},{0,0,-1,-2,-4,0}};
        System.out.println(hourglassSum(arr));
    }
}
