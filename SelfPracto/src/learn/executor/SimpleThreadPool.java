package com.learn.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i = 1; i < 1200; i++){
            Runnable worker = new WorkerThread(""+i);
            executor.execute(worker);
        }

        executor.shutdown();
        while(!executor.isTerminated()){}
        System.out.println("Finished all Threads");
    }
}
