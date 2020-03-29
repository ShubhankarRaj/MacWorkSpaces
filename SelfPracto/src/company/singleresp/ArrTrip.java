package com.company.singleresp;

public class ArrTrip {
    public long arrayTrip(int[] arr, int k) {
        long sumOfTrip = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0)
                sumOfTrip += arr[i];
            else if(arr[i] < 0){
                int maxInRange = Integer.MIN_VALUE;
                int indexOfMaxValue = i;

                int maxRangeOfTravel = arr.length-(i+1) > k ? k : (arr.length - (i+1));
                for(int j = i+1; j <= i + maxRangeOfTravel; j++){
                    if(arr[j] > 0){
                        sumOfTrip += arr[j];
                        i = j;
                        break;
                    }else{
                        if(arr[j] > maxInRange){
                            maxInRange = arr[j];
                            indexOfMaxValue = j;
                        }
                    }

                }
                if(maxInRange > Integer.MIN_VALUE){
                    sumOfTrip += maxInRange;
                    i = indexOfMaxValue;
                }
            }
        }
        return sumOfTrip;

    }


    public static void main(String[] args) {
        ArrTrip arr = new ArrTrip();
        int a[] = {3,4,-1,-3,-4,2,5};
        int k = 2;
        System.out.println(arr.arrayTrip(a, k));

    }
}
