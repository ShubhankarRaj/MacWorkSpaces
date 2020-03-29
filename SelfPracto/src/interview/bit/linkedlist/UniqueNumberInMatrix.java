package com.interview.bit.linkedlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueNumberInMatrix {
 /*   public static  Integer function1(List<List<Integer>> matrix){
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        Map<Integer,List<String>> rowsToColMax = new HashMap<>();
        Map<Integer,List<String>> rowsToColMin = new HashMap<>();

        //  Iterating ROWS wise
        int colIdRowmax = -1;
        int colIdRowMin = -1;
        for(int i = 0 ; i < rows; i++){
            int rowsMax = Integer.MIN_VALUE;
            int rowsMin = Integer.MAX_VALUE;
            for(int j = 0; j < cols; j++){
                if(matrix.get(i).get(j) > rowsMax) {
                    rowsMax = matrix.get(i).get(j);
                    colIdRowmax = j;
                }
                if(matrix.get(i).get(j) < rowsMin) {
                    rowsMin = matrix.get(i).get(j);
                    colIdRowMin = j;
                }
            }

            //  Checking for minimum/maximum within the column
            for(int k = 0; k < rows; k++){
                if(rowsMax <= matrix.get(k).get(colIdRowmax)){
                    break;
                }else if(k == (rows - 1)){
                    rowsToColMax.put(colIdRowmax, );
                }
            }


        }
    }*/
}




