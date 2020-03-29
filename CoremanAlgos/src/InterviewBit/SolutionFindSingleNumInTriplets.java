package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj8lm on 17/07/18.
 */
public class SolutionFindSingleNumInTriplets {

    public int singleNumber(final List<Integer> A) {
        int SIZEFORINT = 32;

        int result = 0;
        int x = 1;

        for (int i = 0; i < SIZEFORINT; i++){
            int sum = 0;

            for(int a: A){
                if((a & x) == 0){
                    sum += 1;
                }
            }

            if((sum % 3) == 0)
                result |= x;

            x = x << 1;
        }

        return result;
    }

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(10);
        SolutionFindSingleNumInTriplets sol = new SolutionFindSingleNumInTriplets();
        System.out.println(sol.singleNumber(arr));
    }
}
