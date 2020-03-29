package interview.bit.stacksandqueues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindMaxNComplexity {

    public int[] slidingMaximum(final int[] A, int B) {

        if(A.length==0) return new int[0];

        int [] result = new int[A.length - B +1];
        int left=0;
        int max = Integer.MIN_VALUE;

        for(int right=0; right < A.length; right++){

            max = Math.max(max,A[right]);

            if( (right-left) == B-1){

                result[left] = max;

                if(A[left] == max){
                    max = Integer.MIN_VALUE;
                    for(int i = left+1; i <= right; i++){
                        max = Math.max(max, A[i]);
                    }
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindMaxNComplexity sol = new SlidingWindMaxNComplexity();
        int input[] = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(sol.slidingMaximum(input, 3)));
    }
}
