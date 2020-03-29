package com.learn.misc;

/**
 * Created By MMT6540 on 11 Jul, 2018
 */
public class SolutionPartition {

    public int sum(int A[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += A[i];
        return total;
    }

    public int partition(int A[], int n, int k) {
        if (k == 1)
            return sum(A, 0, n-1);
        if (n == 1)
            return A[0];

        int best = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            best = Integer.min(best, Integer.max(partition(A, j, k - 1), sum(A, j, n - 1)));
            //System.out.println(best);
        }
        return best;
    }

    public static void main(String[] args){
        SolutionPartition sol = new SolutionPartition();
        //int[] arr = {4, 7, 12, 5, 3, 16};
        int[] arr = {658, 786, 531, 47, 169, 397, 914};
        int numberOfPainters = 5;
        System.out.println((sol.partition(arr, arr.length, numberOfPainters)*10)%10000003);
    }

}