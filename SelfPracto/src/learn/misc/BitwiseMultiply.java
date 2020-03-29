package com.learn.misc;

public class BitwiseMultiply {
    static int multiply(int n, int m)
    {
        int ans = 0, count = 0;
        while (m > 0)
        {
            // check for set bit and left
            // shift n, count times
            System.out.println("m = "+m);
            if (m % 2 == 1) {
                System.out.println("doing a left shift "+count+" times!");
                ans += n << count;
            }
            System.out.println("ANS = "+ans);
            System.out.println("count = "+count);
            // increment of place
            // value (count)
            count++;
            m /= 2;
            System.out.println("-------------");
        }

        return ans;
    }

    // Driver code
    public static void main (String[] args)
    {
        int n = 9, m = 6;

        System.out.print( multiply(n, m) );
    }
}
