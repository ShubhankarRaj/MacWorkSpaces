package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 13/07/18.
 */
public class SolutionMaxNumberOfPagesAllocation {
    public int books(ArrayList<Integer> A, int B) {
        int totalNumOfPages = 0;
        int totalStudents = B;

        if(A.size() < totalStudents){
            //  This means that few students will not get books
            return -1;
        }
        for(int pageInBooks : A)
            totalNumOfPages += pageInBooks;

        int low = 0, mid = 0;

        while(low < totalNumOfPages){
            mid = (low + totalNumOfPages)/2;

            if(possibleToDistributeBooks(A, mid, totalStudents))
                totalNumOfPages = mid;
            else
                low = mid+1;
        }

        return totalNumOfPages;
    }

    private boolean possibleToDistributeBooks(ArrayList<Integer> arrOfBookPages, int averagePageCount, int students){

        int studentCount = 1;
        int currPageCount = 0;
        for(int i = 0; i < arrOfBookPages.size(); i++){
            currPageCount += arrOfBookPages.get(i);
            if(currPageCount > averagePageCount){
                studentCount++;
                currPageCount = arrOfBookPages.get(i);
                if(currPageCount > averagePageCount || studentCount > students)
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        ArrayList<Integer> arrOfBooks = new ArrayList<>();
        arrOfBooks.add(12);
        arrOfBooks.add(34);
        arrOfBooks.add(67);
        arrOfBooks.add(90);

        SolutionMaxNumberOfPagesAllocation sol = new SolutionMaxNumberOfPagesAllocation();
        System.out.println(sol.books(arrOfBooks, 2));
    }
}
