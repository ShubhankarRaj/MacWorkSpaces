package com.company.singleresp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExponentialGrowth {
    public long exponentialGrowth(long[] array, int n){
        boolean searchFlag = false;
        for(long val : array){
            if(val == n){
                searchFlag = true;
            }
        }
        if(!searchFlag) {
            return 0;
        }else{
            List<Long> listOfEvenAndN = new ArrayList<>();

            for(long val : array){
                if((val == n )|| ((val%2 == 0) && (val > n))){
                    listOfEvenAndN.add(val);
                }
            }

            Collections.sort(listOfEvenAndN);
            long maxValueOfN = Long.MIN_VALUE;
            long refValue = Long.valueOf(n);
            for(long newVal : listOfEvenAndN){
                if(newVal == refValue){
                    maxValueOfN = newVal * 2;
                    refValue = maxValueOfN;
                }
            }
            return maxValueOfN;
        }

    }
}
