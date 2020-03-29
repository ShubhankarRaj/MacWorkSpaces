
package com.hacker.rank.interviewprep.graphs;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RoadsAndLibraries {
    private static final Scanner scanner = new Scanner(System.in);
    static Boolean[] visited;
    static int roadToBeRepairedCount = 0;
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        //  If cost of library is cheaper than roads, then calculation is straight forward


        long noOfClusters = 0L;
         visited = new Boolean[n+1];
        roadToBeRepairedCount = 0;

         if(cities.length == 0 || cities.equals(null)){
             return ((long)n * (long)c_lib);
         }
        //Collections.fill(visited, Boolean.FALSE);

        List<TreeSet<Integer>> adjMat = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            if(i != n)
                visited[i+1] = false;
            adjMat.add(new TreeSet<>());
        }

        for(int[] city : cities){
            adjMat.get(city[0]).add(city[1]);
            adjMat.get(city[1]).add(city[0]);
        }

        if(c_lib < c_road){
            return ((long)n * (long)c_lib);
        }else{
            noOfClusters = DFS(cities, adjMat);
            for(int i = 1; i < visited.length; i++){
                if(!visited[i]){
                    noOfClusters++;

                }
            }
            System.out.println(Long.valueOf(c_lib * noOfClusters + roadToBeRepairedCount * c_road));
            return Long.valueOf(c_lib * noOfClusters + roadToBeRepairedCount * c_road);
        }

    }

    static long DFS(int[][] allCities, List<TreeSet<Integer>> adjMat){
        long clusterCount = 0;
        for(int[] city : allCities){
            if(!visited[city[0]]) {
                clusterCount++;
                visited[city[0]] = true;
                DFSUtil(city[0], adjMat);
            }
        }
        return clusterCount;
    }

    static void DFSUtil(int cityFound, List<TreeSet<Integer>> adjMat){

        TreeSet<Integer> cityNetwork = adjMat.get(cityFound);
        for(Integer city: cityNetwork){
            if(!visited[city]) {
                roadToBeRepairedCount++;
                visited[city] = true;
                DFSUtil(city, adjMat);
            }
        }

    }


    /*public static void main(String[] args) {
        int[][] cities = {{6,4}, {3,2}, {7,1}};
        int noOfCitites = 8;
        int costOfLib = 10;
        int costOfRoad = 55;

        System.out.println(roadsAndLibraries(noOfCitites, costOfLib, costOfRoad, cities));
    }*/



    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}

