package com.learn.code.jam.qualification;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ForegoneSol implements Callable<String> {


    String number;
    int testNo;

    public ForegoneSol(String number, int testNo) {
        this.testNo = testNo;
        this.number = number;
    }

    @Override
    public String call() {
        BigInteger number1, number2;
        String removedFour = number.replaceAll("4", "A");
        removedFour = removedFour.replaceAll("\\d", "0");
        removedFour = removedFour.replaceAll("A", "1");

        number1 = new BigInteger(removedFour);
        number2 = new BigInteger(number).subtract(number1);
        //System.out.println(removedFour);
        return "Case #" + testNo + ": " + number1 + " " + number2;
    }

    public static void main(String[] args) {
        boolean DEBUG = false;
        try {
            InputStreamReader r = DEBUG ? new InputStreamReader(new FileInputStream("practice/test.in")) : new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            int testCases = Integer.parseInt(br.readLine());

            ExecutorService threadPool = Executors.newFixedThreadPool(DEBUG ? 1 : Runtime.getRuntime().availableProcessors());
            List<ForegoneSol> tests = new ArrayList<>();
            for (int i = 1; i <= testCases; i++) {
                String input = br.readLine();
                tests.add(new ForegoneSol(input, i));
            }

            List<Future<String>> results = threadPool.invokeAll(tests);
            for (Future<String> f : results) {
                System.out.println(f.get());
            }
            threadPool.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

