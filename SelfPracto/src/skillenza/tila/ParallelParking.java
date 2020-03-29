package com.skillenza.tila;

import java.util.ArrayList;
import java.util.Scanner;

public class ParallelParking {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int numOfTestCases = scn.nextInt();
        for (int i = 1; i <= numOfTestCases; i++) {
            Integer numberOfCarsParked = scn.nextInt();

            ArrayList<ArrayList<Integer>> inputArr = new ArrayList<>();
            for(int j = 1; j <= numberOfCarsParked; j++){
                Scanner newScan = new Scanner(System.in);
                String markers = newScan.nextLine();
                String[] markerArr = markers.split(" ");
                String startNode = markerArr[0];
                String endNode = markerArr[1];
            }


        }
    }

}