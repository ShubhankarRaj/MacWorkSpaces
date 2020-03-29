package com.learn.code.jam.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class TroubleSort {

    private static boolean DEBUG = false;

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        long beginTime = System.nanoTime();

        ExecutorService threadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
        List<Test> tests = new ArrayList<>();

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        int totalTestCount = Integer.parseInt(br.readLine());
        for(int testNo = 1; testNo <= totalTestCount; testNo++){
            int valCount = Integer.parseInt(br.readLine());
            String[] inputStrings = br.readLine().split(" ");
            int[] listOfValues = Arrays.asList(inputStrings).stream().mapToInt(Integer::parseInt).toArray();
            tests.add(new Test(testNo, valCount, listOfValues));
        }
        List<Future<String>> results = threadPool.invokeAll(tests);
        for (Future<String> f : results) {
            System.out.println(f.get());
        }
        threadPool.shutdown();
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }

    private static class Test implements Callable<String>
    {
        private final int testNo;
        private final int totalCountOfVals;
        private final int[] valToSort;

        public Test(int testNo, int totalValuestoSort, int[] valToSort) {
            this.testNo = testNo;
            this.totalCountOfVals = totalValuestoSort;
            this.valToSort = valToSort;
        }


        @Override
        public String call() throws Exception {
            System.err.println("Case #" + testNo + ", " + valToSort.length + " values");
            if(valToSort.length < 3)
                return null;

            int[] arrOfEvnIndices = new int[(valToSort.length+1) / 2];
            int[] arrOfOddIndices = new int[(valToSort.length) / 2];

            for(int i = 0; i < valToSort.length; i += 2) arrOfEvnIndices[i/2] = valToSort[i];
            for(int i = 1; i < valToSort.length; i += 2) arrOfOddIndices[i/2] = valToSort[i];

            Arrays.sort(arrOfEvnIndices);
            Arrays.sort(arrOfOddIndices);

            int prevVal = arrOfEvnIndices[0];
            for(int i = 0; i < valToSort.length; i++){
                int currentValueForEval = i % 2 == 0 ? arrOfEvnIndices[i/2] : arrOfOddIndices[i/2];
                if(currentValueForEval < prevVal) return "Case #" + testNo + ": " + (i - 1);
                prevVal = currentValueForEval;
            }
            return "Case #" + testNo + ":" + " OK";
        }

    }
}
