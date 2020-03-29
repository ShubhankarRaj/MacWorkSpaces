package com.learn.code.jam.round1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Pylons {
    private static boolean DEBUG = false;
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        long beginTime = System.nanoTime();

        ExecutorService threadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
        List<Test> tests = new ArrayList<>();

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        int totalTestCount = Integer.parseInt(br.readLine());
        for (int testNo = 1; testNo <= totalTestCount; testNo++) {
            String sizeOfGalaxy = br.readLine();
            tests.add(new Test(testNo, sizeOfGalaxy));
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
            boolean possible = false;

            if((galaxy.length > 2) || (rows <= 3 && cols <= 3) || (((rows + cols) % 2 == 0) && (rows % 2 != 0)) || (((rows + cols) % 2 == 0) && ((rows == 4 && cols == 2 ) || (rows == 2 && cols == 4))) )
                return "Case #" + testCaseNo + ": IMPOSSIBLE";

            //  It is possible only if either row or column is Odd and odd one is greater than 3 OR
            //  both row and col are even
            if(((rows + cols) % 2 != 0) || (((rows + cols) % 2 == 0) && (rows % 2 == 0)))
                possible = true;

            String galaxyJumpPath = "POSSIBLE";
            if(possible) {
                galaxyJumpPath += "\n" + returnCordinates(rows, cols);
            }


            return "Case #" + testCaseNo + ": "+galaxyJumpPath;
        }

        private String returnCordinates(int rows, int cols) {
            String returnCordinates = new String("");
            //  There are 3 ways in which we we can get the rows and cols
            //  1. row is even and col is even  - in this case, we can fill each two rows firs and then move on
            //  2. row is even and col is odd - in this case, we can fill the 1st and 3rd rows first, 2nd and 4th rows next, and so on...
            //  3. row is odd and col is even - in this case, we can fill the 1st and 2nd columns first and the subsequent columns after that.
            if((rows % 2 == 0) && (cols % 2 == 0)){
                for(int i = 2; i <= rows; i+=2){
                    for(int j = 3; j <= cols; j++){
                        returnCordinates += i + " " + j + "\n";
                        returnCordinates += (i-1) + " " + (j-2) + "\n";
                    }
                    for(int j = 1; j <= 2; j++){
                        returnCordinates += i + " " + j + "\n";
                        returnCordinates += (i-1) + " " + (cols - j + 1) + "\n";
                    }
                }
            }else if(rows % 2 == 0){
                for(int i = 2; i <= rows; i+=2){
                    for(int j = 3; j <= cols; j++){
                        returnCordinates += i + " " + j + "\n";
                        returnCordinates += (i-1) + " " + (j-2) + "\n";
                    }
                    for(int j = 1; j <= 2; j++){
                        returnCordinates += i + " " + j + "\n";
                        returnCordinates += (i-1) + " " + (cols - j + 1) + "\n";
                    }
                }
            }else if(rows % 2 != 0){
                for(int i = 1; i <= cols-1; i+=2){
                    for(int j = 3; j <= rows; j++){
                        returnCordinates += j + " " + i + "\n";
                        returnCordinates += (j-2) + " " + (i+1) + "\n";
                    }
                    for(int j = 1; j <= 2; j++){
                        returnCordinates += j + " " + i + "\n";
                        returnCordinates += (rows - j + 1) + " " + (i+1) + "\n";
                    }
                }
            }

            return returnCordinates;
        }
    }
}