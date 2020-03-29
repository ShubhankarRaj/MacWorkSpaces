package com.hacker.rank.interviewprep.arrays;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        int[] arr1 = new int[5];

        System.arraycopy(arr, 2, arr1, 0,3 );
        System.arraycopy(arr, 0, arr1, 3,2 );
        for(int i : arr1) {
            System.out.println(i);
        }

    }
}
