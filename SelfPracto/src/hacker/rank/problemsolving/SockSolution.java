package com.hacker.rank.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class SockSolution {

    static int sockMerchant(int n, int[] ar) {
        int pairOfSocks = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : ar){
            if(map.containsKey(i)){
                int curValue = map.get(i);
                map.put(i, curValue+1);
            }else{
                map.put(i, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pairOfSocks += entry.getValue()/2;
        }

        return pairOfSocks;
    }
}
