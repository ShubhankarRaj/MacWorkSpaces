package com.skillenza.tila;

import java.util.*;

public class DimmestStar {

    static int longestEdge = Integer.MIN_VALUE;
    static String dimmestStar = new String("0");

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int numOfTestCases = scn.nextInt();
        for(int i = 1; i <= numOfTestCases; i++){
            Integer numOfStars = scn.nextInt();


            //
            Map<String, ArrayList<String>> map = new HashMap<>();

            for(int j = 1; j < numOfStars; j++){
//                Scanner newScan = new Scanner(System.in);
//                String edge = newScan.nextLine();
//                String[] nodes = edge.split(" ");
                //String startNode = nodes[0];
                String startNode = String.valueOf(scn.nextInt());
                //String endNode = nodes[1];
                String endNode = String.valueOf(scn.nextInt());


                //
                if(map.containsKey(startNode)){

                    ArrayList<String> valueList =  map.get(startNode);
                    valueList.add(endNode);
                }else{
                    map.put(startNode, new ArrayList<>(Arrays.asList(endNode)));
                }

            }
            String brightestStar = scn.next();
            DimmestStar dimStar = new DimmestStar();
            //dimStar.findDimmestStar(brightestStar, graph);
            dimStar.findDimmestStar(brightestStar, map);
            System.out.println(dimmestStar);
            //  Resetting the values for the static variables
            longestEdge = 0;
            dimmestStar = new String("0");
        }
    }

    private void findDimmestStar(String brightestStar, Map<String, ArrayList<String>> adjacencyGraph){


        if(!adjacencyGraph.containsKey(brightestStar))
            System.out.println(" ");
        else

            iterateConstellation(brightestStar, adjacencyGraph, 0);

    }

    private void iterateConstellation(String rootStar, Map<String, ArrayList<String>> adjMap, int edgeLength){
        if(!adjMap.containsKey(rootStar)){
            if(edgeLength > longestEdge){
                longestEdge = edgeLength;
                dimmestStar = rootStar;
            }
        }else{
            ArrayList<String> vertices = adjMap.get(rootStar);
            edgeLength = edgeLength + 1;
            for(String vertex : vertices){
                iterateConstellation(vertex, adjMap, edgeLength);
            }
        }
    }

}


