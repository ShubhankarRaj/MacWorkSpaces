package com.learn.executor;

import java.util.concurrent.*;

/**
 * Created By MMT6540 on 17 Apr, 2018
 */
public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(() ->{
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        while(!future.isDone()){
            System.out.println("Do something while Executing Callable");
            Thread.sleep(200);
        }


        System.out.println("Retrieving the Results of the Future");
        String result = future.get();
        System.out.println("Printing Result : "+result);

        System.out.println("Shutting down Executor");
        executorService.shutdown();
    }
}