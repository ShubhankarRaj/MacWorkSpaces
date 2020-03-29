package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 17/07/18.
 */
public class SolutionNumrange {

    ArrayList<ArrayList<Integer>> listOfSubs = new ArrayList<>();
    Boolean setAdditionOfSingle = true;


    public int numRange(ArrayList<Integer> A, int B, int C) {
        if(A.size() == 0)
            if (A.get(0) >= B && A.get(0) <= C)
                return 1;
            else
                return 0;

        int countOfContinousSubseq = 0;

        ArrayList<ArrayList<Integer>> listOfSubSeq = getListOfSubSeq(A, 0, A.size());
        for(ArrayList<Integer> seqList : listOfSubSeq){
            int sum = 0;
            for(Integer seq: seqList){
                sum += seq;
            }
            if(sum >=B && sum <= C)
                countOfContinousSubseq++;
        }
        return countOfContinousSubseq;

    }

    private ArrayList<ArrayList<Integer>> getListOfSubSeq(ArrayList<Integer> list, int startingPoint, int size){

        while(startingPoint < size){
            int originalSize = size;
            while(originalSize > startingPoint){
                ArrayList<Integer> subs = new ArrayList<>();
                for(int i = startingPoint; i < originalSize; i++){
                    subs.add(list.get(i));
                }
                listOfSubs.add(subs);
                originalSize --;
            }
            startingPoint ++;
        }
        return listOfSubs;
    }

    public static void main(String[] args) {
        ArrayList<Integer> listOfNum = new ArrayList<>();
        listOfNum.add(10);
        listOfNum.add(5);
        listOfNum.add(1);
        listOfNum.add(0);
        listOfNum.add(2);

        SolutionNumrange sol = new SolutionNumrange();
        sol.numRange(listOfNum, 6, 8);
    }
}
