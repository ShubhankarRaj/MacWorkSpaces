package interview.bit.stacksandqueues;

import java.util.Stack;

public class TrappedRainWater {

    public int trap(final int[] A) {
        //  MY VERY SILLY ATTEMPT
        /*int leftWall = 0;
        boolean wallStarted = false;
        boolean dipFound = false;
        boolean leftWallFormation = false;
        boolean rightWallFormation = false;
        int rightWall = 0;
        Stack<Integer> stack = new Stack<>();
        int unitOfWater = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for(int i=0; i<A.length; i++){
            //  Handling the initial condition
            if(!wallStarted && A[i] != 0) {
                leftWall = A[i];
                stack.push(i);
                maxLeft = A[i];
                wallStarted = true;
                leftWallFormation = true;
            }
            if(leftWallFormation && A[i] < leftWall){
                dipFound = true;
                leftWall = A[i];
                stack.push(i);

            }else if(leftWallFormation && A[i] >= leftWall && dipFound == false){
                leftWall = A[i];
                if(A[i] >= maxLeft)
                    maxLeft = A[i];
                while(!stack.isEmpty())
                    stack.pop();

                stack.push(i);

            }else if(leftWallFormation && A[i] > leftWall && dipFound == true){
                rightWall = A[i];
                if(A[i] > maxRight)
                    maxRight = A[i];
                rightWallFormation = true;
                leftWallFormation = false;
                stack.push(i);
            }else if(rightWallFormation && A[i] > rightWall){
                rightWall = A[i];
                if(A[i] > maxRight)
                    maxRight = A[i];
                stack.push(i);
            }else if(rightWallFormation && A[i] < rightWall){
                leftWallFormation = true;
                leftWall = A[i];
                rightWallFormation = false;

                int waterLevel = 0;
                waterLevel = Math.min(maxRight, maxLeft);

                while (!stack.isEmpty()){
                    int val = A[stack.pop()];

                    if(val < waterLevel){
                        unitOfWater = unitOfWater + (waterLevel - val);
                    }
                }
                stack.push(i);
                maxRight = 0; maxLeft = A[i - 1];
                waterLevel = 0;
            }


        }
        return unitOfWater;*/

        //  Referred from LEETCODE: https://www.programcreek.com/2014/06/leetcode-trapping-rain-water-java/

        //  Scan the array from left to right and get the maximum height for a given index when coming from either left or right, store them in separate arrays,
        //  find the minimum for every given index and subtract it with the given height

        int unitOfWater = 0;
        if(A == null || A.length == 2)
            return unitOfWater;

        int leftScan[] = new int[A.length];
        int rightScan[] = new int[A.length];

        //  Scanning left to right
        int max = A[0];
        leftScan[0] = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] < max)
                leftScan[i] = max;
            else{
                leftScan[i] = A[i];
                max = A[i];
            }
        }

        //  Scanning from right to left
        max = A[A.length - 1];
        rightScan[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i >= 0; i--){
            if(A[i] < max)
                rightScan[i] = max;
            else{
                rightScan[i] = A[i];
                max = A[i];
            }
        }

        for(int i = 0; i<A.length; i++ ){
            unitOfWater += Math.min(leftScan[i], rightScan[i]) - A[i];
        }

        return unitOfWater;
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappedRainWater trpped = new TrappedRainWater();
    }

}
