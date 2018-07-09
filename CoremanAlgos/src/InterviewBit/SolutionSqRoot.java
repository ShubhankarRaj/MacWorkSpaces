package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj8lm on 24/06/18.
 */
public class SolutionSqRoot {
    public static int sqrt(int number) {
        int t = 0;

        int squareRoot = number / 2;
        if(number == 0)
            return 0;

        if(number == 1)
            return 1;

        if(number == 3)
            return 1;

        ArrayList<Integer> listOfUniqueRoots = new ArrayList<>();
        boolean flagToSendNextRoot = false;


        do {
            if(listOfUniqueRoots.contains(squareRoot)){
                //return listOfUniqueRoots.get(listOfUniqueRoots.size() - 1);
                flagToSendNextRoot = true;
            }

                t = squareRoot;
                listOfUniqueRoots.add(t);
                squareRoot = (t + (number / t)) / 2;
                if(flagToSendNextRoot){
                    return squareRoot;
                }

        } while ((t - squareRoot) != 0);

        return squareRoot;
    }


    public static void main(String[] args) {
        System.out.println(sqrt(3));
    }

}
