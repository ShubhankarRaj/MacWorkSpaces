package com.learn.code.jam.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class YouCanGoYourWay {

    private static boolean DEBUG = false;

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        long beginTime = System.nanoTime();

        ExecutorService threadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
        List<Test> tests = new ArrayList<>();

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        int totalTestCount = Integer.parseInt(br.readLine());
        for (int testNo = 1; testNo <= totalTestCount; testNo++) {
            int sizeOfMaze = Integer.parseInt(br.readLine());
            String lydiasPath = br.readLine();
            tests.add(new Test(testNo, sizeOfMaze, lydiasPath.toUpperCase()));
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
        private final int mazeSize;
        private final String lydiaPath;

        public Test(int testCaseNo, int mazeSize, String lydiaPath) {
            this.testCaseNo = testCaseNo;
            this.mazeSize = mazeSize;
            this.lydiaPath = lydiaPath;
        }


        @Override
        public String call() throws Exception {

            ArrayList<Character> lydiaPathArr
                    = new ArrayList<>(
                    lydiaPath.chars()
                            .mapToObj(e -> (char) e)
                            .collect(
                                    Collectors.toList()
                            )
            );


            StringBuilder myPath = new StringBuilder();
            for (char lydiaPath : lydiaPathArr) {
                if (lydiaPath == 'E')
                    myPath.append(lydiaPath);

                else
                    myPath.append(lydiaPath);
            }

            return "Case #" + testCaseNo + ": " + myPath.toString();
        }
    }

}
