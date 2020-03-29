package InterviewBit;

import java.util.ArrayList;



/**
 * Created by raj8lm on 12/07/18.
 */
public class SolutionPainterPartitionRefOwn {

    public int paint(int A, int B, ArrayList<Integer> C) {
        int painters = A;
        int max = 0;
        for(int c : C){
            max += c;
        }

        int low = 0;

        while(low < max){
            int mid = (low + max)/2;

            if(givenAverageIsSufficientForAllPainters(painters, mid, C))
                max = mid;
            else
                low = mid + 1;
        }

        return (int)(((long)max*B)%10000003);
    }

    private boolean givenAverageIsSufficientForAllPainters(int totalPainters, int averageTime, ArrayList<Integer> arr){
        int painterCount = 1;
        int currTime = 0;

        for(int i = 0 ; i < arr.size(); i++){
            currTime += arr.get(i);
            if(currTime > averageTime){
                painterCount += 1;
                currTime = arr.get(i);
                if(currTime > averageTime || painterCount > totalPainters)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolutionPainterPartitionRefOwn sol = new SolutionPainterPartitionRefOwn();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1000000);
        arr.add(1000000);
        /*arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);*/
        System.out.println(sol.paint(1, 1000000, arr));
    }
}
