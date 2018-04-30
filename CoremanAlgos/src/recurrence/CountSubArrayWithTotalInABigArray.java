package recurrence;

/**
 * Created by raj8lm on 31/03/18.
 */
public class CountSubArrayWithTotalInABigArray {

    static int subsetCount = 0;

    public static void main(String[] args) {
        int[] theArray = {2, 5, 6, 1, 9, 10, 3, 4, 7, 16};
        int desiredSumAmount = 16;
        int countOfSubsetsAddingToSum = getSubsetCountWithTotal(theArray, desiredSumAmount);
        System.out.println(countOfSubsetsAddingToSum);
    }

    static int getSubsetCountWithTotal(int[] theArr, int sumOfSubset){

        //  WE are going to iterate through the length of the subset throughout the array
        //  NOW this length is going to be incremental and also it need not to be contiguous
        int lengthOfSubset = 1;

        subsetCount =createSubSetAndAddThem(theArr, sumOfSubset, theArr.length -1 );
        return subsetCount;

    }

    static int createSubSetAndAddThem(int[] theArr, int sumTotal, int index){
        if (sumTotal == 0){
            return 1;
        }
        if (sumTotal < 0){
            return 0;
        }
        if (index < 0){
            return 0;
        }

        else if(sumTotal < theArr[index]){
            return createSubSetAndAddThem(theArr, sumTotal, index-1);
        }
        else{
            return createSubSetAndAddThem(theArr, sumTotal, index-1) + createSubSetAndAddThem(theArr, sumTotal - theArr[index], index-1);
        }
    }
}
