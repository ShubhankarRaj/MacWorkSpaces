package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj8lm on 15/07/18.
 */
public class SolutionFindSingleNumberinArray {
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        if(A.size() == 1)
            return A.get(0);

        for(int i=0; i < A.size()-1; i++){
            System.out.print("After XOR of "+A.get(i)+" and "+A.get(i+1));

            if(i == 0) {
                result = A.get(i)^A.get(i + 1);

            }
            else {
                result = result^A.get(i + 1);
            }
            System.out.println("->"+result);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);
        /*list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);*/
        SolutionFindSingleNumberinArray sol = new SolutionFindSingleNumberinArray();
        System.out.println("The Odd One Out is "+sol.singleNumber(list));
    }
}
