package com.learn.code.jam.round1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class PylonsRecursion {
    private static boolean DEBUG = false;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        long beginTime = System.nanoTime();

        //ExecutorService threadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
        List<PylonsRecursion.Test> tests = new ArrayList<>();

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        int totalTestCount = Integer.parseInt(br.readLine());
        for (int testNo = 1; testNo <= totalTestCount; testNo++) {
            String sizeOfGalaxy = br.readLine();
            tests.add(new PylonsRecursion.Test(testNo, sizeOfGalaxy));
        }

        //List<Future<String>> results = threadPool.invokeAll(tests);

        for (Test test : tests) {
            System.out.println(executeTest(test));
        }

        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");

    }

    public static String executeTest(Test test) {
        int[] galaxy = Stream.of(test.galaxySize.split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = galaxy[0];
        int cols = galaxy[1];


        if ((galaxy.length > 2) || (rows <= 3 && cols <= 3))
            return "Case #" + test.testCaseNo + ": IMPOSSIBLE";

        String galaxyJumpPath = returnPossiblity(rows, cols);
        return "Case #" + test.testCaseNo + " " + rows + " | " + cols + ": " + galaxyJumpPath;
        //return "Case #" + testCaseNo + ": "+galaxyJumpPath;
    }


    private static String returnPossiblity(int rows, int cols) {

        Map<String, List<String>> listOfValidNeighbours = new HashMap<>();
        //  Outer twin for loop for adding co-ordinates in KEYS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                List<String> validNeighbours = new ArrayList<>();
                //  Inner twin loop for adding all valid neighbours list in values
                for (int m = 0; m < rows; m++) {
                    for (int n = 0; n < cols; n++) {
                        if ((m == i) || (j == n) || (Math.abs(i - m) == Math.abs(j - n)) || (i + m == j + n))
                            continue;
                        validNeighbours.add(String.valueOf(m + 1) + "," + String.valueOf(n + 1));
                    }
                }
                if (validNeighbours.size() == 0)
                    return "IMPOSSIBLE";
                listOfValidNeighbours.put(String.valueOf(i + 1) + "," + String.valueOf(j + 1), validNeighbours);
            }
        }

        //  Sorting a Map based upon the size of list in the Value section
        List<List<Object>> listToSort = new LinkedList(listOfValidNeighbours.entrySet());
        Collections.sort(listToSort, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 == null && o2 == null) return 0;
                if (o1 == null) return -1;
                if (o2 == null) return 1;

                int size1 = ((List) ((Map.Entry) (o1)).getValue()).size();
                int size2 = ((List) ((Map.Entry) (o2)).getValue()).size();
                return size1 - size2;
            }
        });

        Map<String, List<String>> sortedListOfNeighbours = new LinkedHashMap();
        for (Iterator it = listToSort.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();

            List<String> l = new ArrayList();
            l = (ArrayList<String>) entry.getValue();
            sortedListOfNeighbours.put(String.valueOf(entry.getKey()), l);
        }

        //  Traversing the sorted map and adding values in the Visited array
        listOfValidNeighbours = sortedListOfNeighbours;
        List<String> cellCoordinates = new ArrayList<>();
        Map.Entry<String, List<String>> entryToAdd = listOfValidNeighbours.entrySet().iterator().next();
        String nextCellWithLowestNeighbours = entryToAdd.getKey();
        cellCoordinates.add(nextCellWithLowestNeighbours);
        String result = findPossiblePath(nextCellWithLowestNeighbours, entryToAdd, listOfValidNeighbours, cellCoordinates);
        return null;
    }

    private static String findPossiblePath(String nextCellWithLowestNeighbours, Map.Entry<String, List<String>> entryToAdd, Map<String, List<String>> listOfValidNeighbours, List<String> cellCoordinates) {
        //Map<String, List<String>> newList = listOfValidNeighbours;

        //Map.Entry<String, List<String>> newEntryObj = entryToAdd;
        //  Validating the size of the Array in which we are adding the co-ordinates
        //  Since all the values are going to be unique and if size of the array is same
        //  as size of the matrix, then we have covered the entire matrix
        if (cellCoordinates.size() == listOfValidNeighbours.size() || ((entryToAdd.getValue().size()) == 0 && (cellCoordinates.size() == listOfValidNeighbours.size() -1))) {
            //  Adding the use case when we are getting at the end of the path and the next path is dead end.
            if((entryToAdd.getValue().size()) == 0 && (cellCoordinates.size() == listOfValidNeighbours.size() -1))
                cellCoordinates.add(entryToAdd.getKey());
            String returnStr = new String("POSSIBLE\n");
            for (int i = 0; i < cellCoordinates.size(); i++) {
                String cell = cellCoordinates.get(i);
                if (i == cellCoordinates.size() - 1)
                    returnStr = returnStr + cell;
                else
                    returnStr = returnStr + cell + "\n";
            }
            return returnStr;
        }

        //  Removing the next cell from all the list of Valid neighbours
        List<String> listOfKeys = new ArrayList<>();
        for (Map.Entry<String, List<String>> coordinateEntry : listOfValidNeighbours.entrySet()) {
            if (coordinateEntry.getValue().contains(nextCellWithLowestNeighbours)) {
                coordinateEntry.getValue().remove(nextCellWithLowestNeighbours);
                listOfKeys.add(coordinateEntry.getKey());
            }
        }
        if (entryToAdd.getValue().size() == 0){

            return null;
        }
        int x = entryToAdd.getValue().size();
        for (int i = 0; i < x; i++){
            if(i < entryToAdd.getValue().size()) {
                String newCell = entryToAdd.getValue().get(i);
                for (Map.Entry<String, List<String>> newEntryToAdd : listOfValidNeighbours.entrySet()) {
                    if (newEntryToAdd.getKey().equals(newCell)) {
                        Map.Entry<String, List<String>> newEntry = newEntryToAdd;
                        cellCoordinates.add(newCell);
                        findPossiblePath(newCell, newEntry, listOfValidNeighbours, cellCoordinates);

                        //  Adding the removed cell from all the list of Valid neighbours
                        for(String eachKey:listOfKeys){
                            List<String> listOfValues = listOfValidNeighbours.get(eachKey);
                            listOfValues.add(nextCellWithLowestNeighbours);
                            listOfValidNeighbours.put(eachKey, listOfValues);
                        }
                        //  Restoring the cell-cordinates which are added
                        cellCoordinates.remove(newCell);

                        break;
                    }
                }
            }
        }
        return null;
    }

    private static class Test {
        private final int testCaseNo;
        private final String galaxySize;

        public Test(int testCaseNo, String galaxySize) {
            this.testCaseNo = testCaseNo;
            this.galaxySize = galaxySize;
        }
    }
}

