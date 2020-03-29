package InterviewBit;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj8lm on 30/06/18.
 */
public class SolutionFindMedianOfSortedArrays {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {


        int sizeOfA = a.size();
        int sizeOfB = b.size();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        if((sizeOfB < sizeOfA)){
            first = b;
            second = a;
        }else if(sizeOfA < sizeOfB){
            first = a;
            second = b;
        }else{
            first = a;
            second = b;
        }


        int low = 0;
        int high = first.size();
        int sizeOfFirst = high;
        int sizeOfSec = second.size();

        while(low <= high){

            int partitionFirst = (low + high) / 2;
            int partitionSec = (sizeOfFirst + sizeOfSec + 1)/2 - partitionFirst;

            int maxLeftFirst = (partitionFirst == 0) ? Integer.MIN_VALUE : first.get(partitionFirst - 1);
            int minRightFirst = (partitionFirst == sizeOfFirst) ? Integer.MAX_VALUE : first.get(partitionFirst);

            int maxLeftSec = (partitionSec == 0) ? Integer.MIN_VALUE : second.get(partitionSec - 1);
            int minRightSec = (partitionSec == sizeOfSec) ? Integer.MAX_VALUE : second.get(partitionSec);

            if(maxLeftFirst <= minRightSec && maxLeftSec <= minRightFirst){
                if((sizeOfFirst+sizeOfSec)%2 == 0){
                    return ((double)Math.max(maxLeftFirst, maxLeftSec)+Math.min(minRightFirst, minRightSec))/2;
                }else
                    return Math.max(maxLeftFirst, maxLeftSec);
            }
            if(maxLeftFirst > minRightSec)
              high = partitionFirst - 1;
            else
                low = partitionFirst + 1;
        }

        throw new IllegalArgumentException();

    }

    public static void main(String[] args) {
        SolutionFindMedianOfSortedArrays sol = new SolutionFindMedianOfSortedArrays();

        List<Integer> firstArr = new ArrayList<>();
        List<Integer> secArr = new ArrayList<>();

        firstArr.add(0); firstArr.add(23); firstArr.add(9); firstArr.add(10); firstArr.add(52);
        secArr.add(-1); secArr.add(11); secArr.add(20); secArr.add(100);

        double median = sol.findMedianSortedArrays(firstArr, secArr);
        System.out.println(median);
    }

}
