package com.hacker.rank.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class FindTriplet {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        int leadCounterA = 0;
        int leadCounterB = 0;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) > b.get(i)){
                leadCounterA += 1;
            }else if(a.get(i) < b.get(i))
            {
                leadCounterB += 1;
            }
        }

        c.add(leadCounterA);
        c.add(leadCounterB);
        return c;
    }

}
