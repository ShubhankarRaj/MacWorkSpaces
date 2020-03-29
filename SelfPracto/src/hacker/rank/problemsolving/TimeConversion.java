package com.hacker.rank.problemsolving;

public class TimeConversion {

    static String timeConversion(String s) {

        String[] arr = s.split(":");
        if(arr[2].contains("AM")) {
            if (Integer.parseInt(arr[0]) != 12)
                return s.substring(0, s.length() - 2);
            else{
                arr[0] = "00";
                return arr[0]+":"+arr[1]+":"+arr[2].substring(0, arr[2].length()-2);
            }
        }
        else{
            if(Integer.parseInt(arr[0]) != 12) {
                arr[0] = Integer.toString(Integer.parseInt(arr[0]) + 12);
            }
            return arr[0]+":"+arr[1]+":"+arr[2].substring(0, arr[2].length()-2);
        }
    }

    public static void main(String[] args) {
        //System.out.println(timeConversion(""));
    }
}
