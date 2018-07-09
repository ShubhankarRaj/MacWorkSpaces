package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 07/07/18.
 */
public class SolutionPrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int value = A;
        boolean incrementInd = false, decrementInd = true;
        int incOrDecCounter = 0;
        for(int i = 0; i < (2*value)/2; i++){
            ArrayList<Integer> intArr = new ArrayList<>();
            for(int j = 0; j < 2*value-1; j++){
                if(j == 0 || j == 2*value-2 || i == 0 || i == 2*value-2){
                    intArr.add(j, value);
                }
                else if(decrementInd && incOrDecCounter < i){
                    incOrDecCounter++;
                    intArr.add(j, value - incOrDecCounter);
                    if((2*value-2) - j == incOrDecCounter){
                        incrementInd = true;
                        decrementInd = false;
                    }

                }else if( !incrementInd ){
                    intArr.add(j, value - incOrDecCounter);
                    if((2*value-2) - j == incOrDecCounter){
                        incrementInd = true;
                        decrementInd = false;
                    }
                }else if(incrementInd){
                    incOrDecCounter--;
                    intArr.add(j, value - incOrDecCounter);

                }

            }
            incOrDecCounter = 0;
            arr.add(intArr);
            incrementInd = false;
            decrementInd = true;
        }
        int sizeOfArr = arr.size();
        for(int i = (2*value)/2+1; i <= 2*value -1; i++){
            ArrayList<Integer> newArrList = arr.get(sizeOfArr - 2);
            sizeOfArr--;
            arr.add(newArrList);
        }
        return arr;
    }

    public static void main(String[] args) {
        SolutionPrettyPrint sol = new SolutionPrettyPrint();
        ArrayList<ArrayList<Integer>> myArr = sol.prettyPrint(4);
    }
}
