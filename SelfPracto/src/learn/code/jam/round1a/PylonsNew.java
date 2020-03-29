package com.learn.code.jam.round1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class PylonsNew {
    private static boolean DEBUG = false;
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        long beginTime = System.nanoTime();

        ExecutorService threadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
        List<PylonsNew.Test> tests = new ArrayList<>();

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        int totalTestCount = Integer.parseInt(br.readLine());
        for (int testNo = 1; testNo <= totalTestCount; testNo++) {
            String sizeOfGalaxy = br.readLine();
            tests.add(new PylonsNew.Test(testNo, sizeOfGalaxy));
        }

        List<Future<String>> results = threadPool.invokeAll(tests);
        for (Future<String> f : results) {
            System.out.println(f.get());
        }
        threadPool.shutdown();
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");

    }

    private static class Test implements Callable<String> {
        private final int testCaseNo;
        private final String galaxySize;


        public Test(int testCaseNo, String galaxySize) {
            this.testCaseNo = testCaseNo;
            this.galaxySize = galaxySize;

        }

        @Override
        public String call() throws Exception {
            int[] galaxy = Stream.of(galaxySize.split(" ")).mapToInt(Integer::parseInt).toArray();
            int rows = galaxy[0];
            int cols = galaxy[1];


            if((galaxy.length > 2) || (rows <= 3 && cols <= 3))
                return "Case #" + testCaseNo + ": IMPOSSIBLE";

            String galaxyJumpPath = returnPossiblity(rows, cols);
            return "Case #" + testCaseNo + " " +rows+ " | " +cols+ ": "+galaxyJumpPath;
            //return "Case #" + testCaseNo + ": "+galaxyJumpPath;
        }

        private String returnPossiblity(int rows, int cols) {

            //List<Map<String, Boolean>> visitedList = new ArrayList<>();
           // int matrix[][] = new int[rows][cols];

            Map<String, List<String>> listOfValidNeighbours = new HashMap<>();
            //  Outer twin for loop for adding co-ordinates in KEYS
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){

                    List<String> validNeighbours = new ArrayList<>();
                    //  Inner twin loop for adding all valid neighbours list in values
                    for(int m = 0; m < rows; m++){
                        for(int n = 0; n < cols; n++){
                            if((m == i) || (j == n) || (Math.abs(i-m) == Math.abs(j-n)) || (i+m == j+n))
                                continue;

                            validNeighbours.add(String.valueOf(m+1)+","+String.valueOf(n+1));
                        }
                    }
                    if(validNeighbours.size() == 0)
                        return "IMPOSSIBLE";
                    listOfValidNeighbours.put(String.valueOf(i+1)+","+String.valueOf(j+1), validNeighbours);
                }
            }

            //  Sorting a Map based upon the size of list in the Value section
            List<List<Object>> listToSort = new LinkedList(listOfValidNeighbours.entrySet());
            Collections.sort(listToSort, new Comparator() {

                @Override
                public int compare(Object o1, Object o2) {
                    if(o1 == null && o2 == null) return 0;
                    if(o1 == null) return -1;
                    if(o2 == null) return 1;

                    int size1 = ((List)((Map.Entry)(o1)).getValue()).size();
                    int size2 = ((List)((Map.Entry)(o2)).getValue()).size();
                    return size1 - size2;
                }
            });

            Map<String, List<String>> sortedListOfNeighbours = new LinkedHashMap();
            for(Iterator it = listToSort.iterator(); it.hasNext();){
                Map.Entry entry = (Map.Entry) it.next();

                List<String> l = new ArrayList();
                l = (ArrayList<String>)entry.getValue();
                sortedListOfNeighbours.put(String.valueOf(entry.getKey()), l);
            }

            //  Traversing the sorted map and adding values in the Visited array
            listOfValidNeighbours = sortedListOfNeighbours;
            List<String> cellCoordinates = new ArrayList<>();
            Map.Entry<String, List<String>> entryToAdd = listOfValidNeighbours.entrySet().iterator().next();

            String nextCellWithLowestNeighbours = entryToAdd.getKey();

            OUTER_LOOP:
            for(int i = 1; i <= rows*cols; i++){

                for(Map.Entry<String, List<String>> coordinateEntry:listOfValidNeighbours.entrySet()){
                    if(coordinateEntry.getValue().contains(nextCellWithLowestNeighbours)){
                        coordinateEntry.getValue().remove(nextCellWithLowestNeighbours);
                    }
                }
                if(i > 1){
                    for(Map.Entry<String, List<String>> newEntryToAdd:listOfValidNeighbours.entrySet()){
                        if(newEntryToAdd.getKey().equals(nextCellWithLowestNeighbours)){
                            entryToAdd = newEntryToAdd;
                            break;
                        }

                    }
                }
                cellCoordinates.add(nextCellWithLowestNeighbours);
                if(i == rows*cols)
                    break OUTER_LOOP;

                /*if(nextCellWithLowestNeighbours.equals("1,1")) {
                    if(!cellCoordinates.contains(rows+","+cols) && (listOfValidNeighbours.get(nextCellWithLowestNeighbours).contains(rows+","+cols))) {
                        nextCellWithLowestNeighbours = rows + "," + cols;
                        continue;
                    }
                }
                else if(nextCellWithLowestNeighbours.equals("1,"+cols)) {
                    if(!cellCoordinates.contains(rows+",1") && (listOfValidNeighbours.get(nextCellWithLowestNeighbours).contains(rows+",1"))){
                        nextCellWithLowestNeighbours = rows + ",1";
                        continue;
                    }
                }else if(nextCellWithLowestNeighbours.equals(rows+",1")) {
                    if(!cellCoordinates.contains("1,"+cols) && (listOfValidNeighbours.get(nextCellWithLowestNeighbours).contains("1,"+cols))){
                        nextCellWithLowestNeighbours = "1," + cols;
                        continue;
                    }
                }else if(nextCellWithLowestNeighbours.equals(rows+","+cols)) {
                    if(!cellCoordinates.contains("1,1") && (listOfValidNeighbours.get(nextCellWithLowestNeighbours).contains("1,1"))){
                        nextCellWithLowestNeighbours = "1,1";
                        continue;
                    }
                }*/

                int sizeOfNeighbours = rows*cols;
                int minDistanceFromNode = rows+cols;
                String currentCell = nextCellWithLowestNeighbours;
                for(String cellInList : entryToAdd.getValue()){
                    int size = listOfValidNeighbours.get(cellInList).size();

                    if(size <= 0 && (entryToAdd.getValue().size() == 1) && i < (rows*cols-1)){
                        return "IMPOSSIBLE";
                    }else if(size <=0 && i == (rows*cols-1)){
                        if(!cellCoordinates.contains(cellInList))
                            cellCoordinates.add(cellInList);
                        break OUTER_LOOP;
                    }
                    if((size !=0) && (size <= sizeOfNeighbours)) {
                        sizeOfNeighbours = size;
                        String[] currCellArr = currentCell.split(",");
                        String[] nextCellArr = cellInList.split(",");
                        int distance = Math.abs(Integer.parseInt(currCellArr[0]) - Integer.parseInt(nextCellArr[0])) + Math.abs(Integer.parseInt(currCellArr[1]) - Integer.parseInt(nextCellArr[1]));
                        if(distance < minDistanceFromNode) {
                            minDistanceFromNode = distance;
                            nextCellWithLowestNeighbours = cellInList;
                        }
                    }
                }


            }

            String returnStr = new String("POSSIBLE\n");
            for (int i = 0; i < cellCoordinates.size(); i++) {
                String cell = cellCoordinates.get(i);
                if(i == cellCoordinates.size() -1)
                    returnStr = returnStr + cell;
                else
                    returnStr = returnStr + cell + "\n";
            }

            return returnStr;
        }


    }
    }
