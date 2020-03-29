package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 17/07/18.
 */
public class SolutionSearchMatrix {

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int rows = a.size();
        int cols = a.get(0).size();
        int i = 0, j = cols-1;
        while(i < rows && j >= 0){
            if(a.get(i).get(j) < b) {
                i++;
                continue;
            }
            else {
                if(a.get(i).get(j) == b)
                    return 1;
                j--;
                if(j < 0)
                    break;
                if(a.get(i).get(j) < b) {
                    i++;
                    continue;
                }else {
                    if(a.get(i).get(j) == b)
                        return 1;
                    else {
                        j--;
                        if(j < 0)
                            break;

                        if (a.get(i).get(j) == b) {
                            return 1;
                        }
                    }
                }
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1); /*first.add(3); first.add(5); first.add(7);*/
       /* ArrayList<Integer> sec = new ArrayList<>();
        sec.add(10); sec.add(11); sec.add(16); sec.add(20);
        ArrayList<Integer> third = new ArrayList<>();
        third.add(23); third.add(30); third.add(34); third.add(50);*/

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(first);
       /* arr.add(sec);
        arr.add(third);*/

        SolutionSearchMatrix sol = new SolutionSearchMatrix();
        sol.searchMatrix(arr,1);
    }
}
