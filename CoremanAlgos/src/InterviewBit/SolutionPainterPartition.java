package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 12/07/18.
 */
public class SolutionPainterPartition {

    private long sum(int from, int to, ArrayList<Integer> A){
        int total = 0;
        for(int i = from; i <= to; i++){
            total += A.get(i);
        }
        return total;
    }

    private long partitionOfWork(int painters, int numberOfBoards, ArrayList<Integer> arr){
        if(painters == 1)
            return sum(0, numberOfBoards-1, arr);
        if(numberOfBoards == 1)
            return arr.get(0);
        long minTime = Integer.MAX_VALUE;
        for(int i = 1; i <= numberOfBoards; i++) {
            //System.out.println("Painters Count "+painters);
            //System.out.println("Partition Sum: "+partitionOfWork(painters - 1, i, arr));
            //System.out.println("Sum :"+sum(i, numberOfBoards - 1, arr));
            minTime = Long.min(minTime, Long.max(partitionOfWork(painters - 1, i, arr), sum(i, numberOfBoards - 1, arr)));
        }

        return minTime;
    }

    public int paint(int A, int B, ArrayList<Integer> C) {
        long minimumTimeAfterPartition = partitionOfWork(A, C.size(), C);
        //long timeTakenToCompleteWork = 0; //B * minimumTimeAfterPartition;
        return (int) minimumTimeAfterPartition;
        //return (int) ((minimumTimeAfterPartition * B) % 10000003);
    }

    public static void main(String[] args) {
        SolutionPainterPartition sol = new SolutionPainterPartition();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(36);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(6);
        arr.add(2);
        arr.add(5);
        arr.add(3);
        arr.add(1);
        System.out.println(sol.paint(3, 1000000, arr));
    }
}
