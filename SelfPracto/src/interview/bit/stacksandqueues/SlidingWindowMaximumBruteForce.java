package interview.bit.stacksandqueues;

import java.util.*;

public class SlidingWindowMaximumBruteForce {

    public int[] slidingMaximum(final int[] A, int B) {

        int[] C = new int[A.length - (B - 1)];
        if(B > A.length) {
            int max = Integer.MIN_VALUE;
            for (int i : A){
                if (i > max)
                    max = i;
            }
            return new int[]{max};
        }
        else{

            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < B; i++){
                if(A[i] > max)
                    max = A[i];

                stack.push(A[i]);
            }
            int returnArrIndex = 0;
            C[returnArrIndex] = max;

            for(int i = 1; i <= A.length - B; i++){
                int max2 = Integer.MIN_VALUE;
                while(stack.size() >= 1){
                    stack.pop();
                }

                int maxTraversal = i + B -1;
                for(int x = i; x <= maxTraversal; x++){
                    int val = A[x];
                    if(val > max2)
                        max2 = val;
                    stack.push(val);
                }
                returnArrIndex++;
                C[returnArrIndex] = max2;

            }


        }


        return C;
    }

    public static void main(String[] args) {
        SlidingWindowMaximumBruteForce sol = new SlidingWindowMaximumBruteForce();
        int input[] = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(sol.slidingMaximum(input, 3)));
    }
}
