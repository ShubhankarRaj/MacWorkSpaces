package InterviewBit;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by raj8lm on 17/07/18.
 */
public class FindKthSmallestElement {
    public int kthsmallest(final List<Integer> A, int B) {

        if( A == null || A.size() == 0)
            throw new IllegalArgumentException("Empty List");

        int hi = Collections.max(A);
        int lo = Collections.min(A);

        while(lo <= hi){
            int countOfLessNos = 0; int countOfEqualNos = 0;

            int mid = lo + (hi - lo)/2;

            for(int i=0; i < A.size(); i++){
                if(A.get(i) < mid)
                    countOfLessNos++;
                else if(A.get(i) == mid)
                    countOfEqualNos++;

                if(countOfLessNos >= B)
                    break;
            }

            if(countOfLessNos < B && (countOfEqualNos+countOfLessNos) >= B)
                return mid;
            else if(countOfLessNos >= B)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};

        //int[] arr = {8, 9, 80, 11,17,10, 10};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());


        FindKthSmallestElement sol = new FindKthSmallestElement();
        System.out.println(sol.kthsmallest(list, 5));
    }
}
