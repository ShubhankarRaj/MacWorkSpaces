package com.learn.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By MMT6540 on 25 Jun, 2018
 */
public class SolSortedArrayRotCount {

    public int findMin(final List<Integer> a) {
       // Integer[] ab = a.toArray(new Integer[a.size()]);
        Integer[] ab = new Integer[]{ 76961, 77242, 78246, 79428, 80505, 80843, 80894, 81082, 81351, 81591, 81990, 82503, 82983, 83668, 84048, 86502, 87162, 87479, 88720, 90773, 91077, 91095, 91204, 91554, 92323, 93043, 93240, 93357, 93745, 94622, 94742, 96173, 97712, 98000, 98616, 99102, 1396, 1577, 2682, 3644, 4749, 5623, 6522, 7245, 8564, 8675, 9671, 10500, 11276, 12033, 12682, 13977, 14324, 14626, 14804, 15036, 15070, 15656, 15660, 16227, 16436, 17591, 18442, 18674, 18770, 19825, 19904, 20836, 21503, 21666, 21755, 22345, 22580, 24128, 24640, 25200, 25610, 25852, 26424, 26675, 28115, 28433, 29053, 29957, 29975, 30020, 30396, 30567, 31821, 33292, 33319, 34040, 34696, 34781, 35770, 36239, 37460, 37507, 38910, 39310, 39947, 40097, 40170, 40354, 40436, 40670, 44373, 44461, 44790, 45024, 45154, 45526, 45758, 46648, 48852, 51549, 54652, 55102, 55455, 55501, 55690, 56135, 56161, 56509, 56674, 57017, 57571, 57821, 58353, 58904, 58906, 59057, 59119, 59443, 60226, 60687, 60973, 61863, 62346, 62475, 63106, 63254, 65085, 65251, 65472, 65529, 66723, 67327, 68770, 69656, 69867, 70632, 71155, 72148, 72185, 72277, 72440, 73058, 73223, 74078, 75208, 76131, 76214, 76776};
        int size = ab.length;
        int low = 0, high = size -1;

        while(low <= high){
            if(ab[low] <= ab[high])
                return low;
            int mid = (low+high)/2;
            int next = (mid + 1)%size;
            int prev = (mid - 1)%size;
            if((ab[mid] <= ab[next]) && (ab[mid] <= ab[prev]))
                return mid;
            if(ab[mid] < ab[low])
                high = mid - 1;
            else if(ab[mid] > ab[high])
                low = mid + 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        SolSortedArrayRotCount sol = new SolSortedArrayRotCount();
        List<Integer> sortedList = new ArrayList<>();
        //  23, 26,100, 102, 4, ,6, 15, 20
        sortedList.add(23);
        sortedList.add(26);
        sortedList.add(100);
        sortedList.add(102);
        sortedList.add(104);
        sortedList.add(105);
        sortedList.add(4);
        sortedList.add(6);
        sortedList.add(15);
        sortedList.add(20);
        sortedList.add(21);

        System.out.println("Number of Times the Array is ROTATED: "+sol.findMin(sortedList));
    }
}