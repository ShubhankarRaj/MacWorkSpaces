package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj8lm on 24/06/18.
 */
public class SolutionFindOccurence {

    public int BinarySearch(Integer[] A, int searchElement, boolean searchFirst){
        int sizeOfArr = A.length;
        int low = 0;
        int high = sizeOfArr - 1;
        int mid = 0;
        int result = -1;

        while(low <= high){
            mid = (low + high)/2;
            if(A[mid] == searchElement){
                if(searchFirst){
                    high = mid - 1;
                    result = mid;
                }else{
                    low = mid + 1;
                    result = mid;
                }
            }else{
                if(searchElement < A[mid]){
                    high = mid - 1;
                }else
                    low = mid + 1;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        ArrayList<Integer> listOfNo = new ArrayList<>();
        //int[] abc = {2, 3, 5, 5, 6, 12, 24, 29};
        listOfNo.add(2);listOfNo.add(3);listOfNo.add(5);listOfNo.add(5);
        listOfNo.add(12);listOfNo.add(24);listOfNo.add(29);
        listOfNo.add(31);listOfNo.add(31);
        SolutionFindOccurence sol = new SolutionFindOccurence();
        System.out.println(sol.findCount(listOfNo, 5));
    }

    public int findCount(final List<Integer> A, int B) {

        Integer[] arr = A.toArray(new Integer[A.size()]);
        SolutionFindOccurence sol = new SolutionFindOccurence();

        int firstOccurence = sol.BinarySearch(arr, B, true);
        if(firstOccurence < 0){
            return 0;
        }
        int lastOccurence = sol.BinarySearch(arr, B, false);

        int occurence = lastOccurence - firstOccurence;
        return occurence+1;
    }


}

