package interview.bit.stacksandqueues;

import java.util.Stack;

public class GreatestAreaInHistogram {
    public int largestRectangleArea(int[] A) {
        int maxArea = 0;

        if(A == null || A.length == 0)
            return 0;

        if(A.length == 1)
            return A[0];

        int currentIndex = 1;
        Stack<Integer> stackOfIndices = new Stack<>();

        while(currentIndex < A.length){
            if(stackOfIndices.isEmpty() || A[currentIndex - 1] >= A[stackOfIndices.peek() - 1]){
                stackOfIndices.push(currentIndex);
                currentIndex++;
            }else{
                int index = stackOfIndices.pop();
                int heightOfRec = A[index - 1];
                int widthOfRec = stackOfIndices.isEmpty() ? (currentIndex - 1) : (currentIndex - stackOfIndices.peek());
                maxArea = Math.max(maxArea, heightOfRec * widthOfRec);
            }
        }

        while(!stackOfIndices.isEmpty()){
            int index = stackOfIndices.pop();
            int heightOfRec = A[index - 1];
            int widthOfRec = stackOfIndices.isEmpty() ? (currentIndex - 1) : (currentIndex - stackOfIndices.peek());
            maxArea = Math.max(maxArea, heightOfRec * widthOfRec);
        }


        return maxArea;
    }

    public int largestRectangleAreaRef(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    public static void main(String[] args) {
        GreatestAreaInHistogram sol = new GreatestAreaInHistogram();
        System.out.println(sol.largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
        System.out.println(sol.largestRectangleAreaRef(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }
}
