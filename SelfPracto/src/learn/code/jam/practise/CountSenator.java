package com.learn.code.jam.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountSenator {

    private static class Test implements Callable<String> {

        private final int testNumber;
        private final int[] partySenators;

        private Test(int testNumber, int[] partySenators) {
            this.testNumber = testNumber;
            this.partySenators = partySenators;
        }

        @Override
        public String call() {
            System.err.println("Case #" + testNumber + ", " + partySenators.length + " parties");
            StringBuilder result = new StringBuilder();
            int senatorCount = 0;
            int partyCount = partySenators.length;
            for (int i = 0; i < partySenators.length; i++) senatorCount += partySenators[i];
            while (senatorCount > 0) {
                if (partyCount == 2) {
                    result.append(' ');
                    for (int i = 0; i < partySenators.length; i++) {
                        if (partySenators[i] > 0) {
                            partySenators[i]--;
                            senatorCount--;
                            if (partySenators[i] == 0) partyCount--;
                            result.append((char) (i + 'A'));
                        }
                    }
                } else {
                    int biggestParty = 0;
                    for (int i = 1; i < partySenators.length; i++) {
                        if (partySenators[i] > partySenators[biggestParty]) biggestParty = i;
                    }
                    partySenators[biggestParty]--;
                    senatorCount--;
                    if (partySenators[biggestParty] == 0) partyCount--;
                    result.append(' ').append((char) (biggestParty + 'A'));
                }
                if (DEBUG) {
                    int majority = (senatorCount + 1 + 1) / 2;
                    for (int i = 0; i < partySenators.length; i++) {
                        assert partySenators[i] < majority;
                    }
                }
            }
            return "Case #" + testNumber + ":" + result.toString();
        }
    }

    private static final boolean DEBUG = false;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException {
        long beginTime = System.nanoTime();
        ExecutorService threadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
        List<Test> tests = new ArrayList<>();
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2018/practice/SenateEvacuation-1.in") : System.in;
        try (Scanner scanner = new Scanner(is)) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int partyCount = scanner.nextInt();
                int[] partySenators = new int[partyCount];
                for (int i = 0; i < partyCount; i++) partySenators[i] = scanner.nextInt();
                tests.add(new Test(testNumber, partySenators));
            }
        }
        List<Future<String>> results = threadPool.invokeAll(tests);
        for (Future<String> f : results) {
            System.out.println(f.get());
        }
        threadPool.shutdown();
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}
