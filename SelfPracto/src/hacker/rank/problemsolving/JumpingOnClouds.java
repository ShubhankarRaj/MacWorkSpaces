package com.hacker.rank.problemsolving;

public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        if(c.length == 2)
            return 1;
        for(int i = 0; i < c.length - 2; ){
            if(c[i+2] == 0) {
                i = i + 2;
                jumps += 1;
            }else{
                i = i+1;
                jumps += 1;
            }
            if(i == c.length - 2 )
                jumps += 1;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 0, 1, 0};

        System.out.println(jumpingOnClouds(arr));
    }
}
