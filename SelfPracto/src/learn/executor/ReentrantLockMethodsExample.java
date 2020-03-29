package com.learn.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created By MMT6540 on 19 Apr, 2018
 */
public class ReentrantLockMethodsExample {

    public static void main(String args[]){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ReentrantLockMethodsCounter reentrantLockMethodsCounter = new ReentrantLockMethodsCounter();

        executorService.submit(() -> {
            System.out.println("Increment Count (First Thread) : "+
            reentrantLockMethodsCounter.incrementAndGet() + "\n");
        });

        executorService.submit(() -> {
            System.out.println("Increment Count (Second Thread) : "+
                    reentrantLockMethodsCounter.incrementAndGet() + "\n");
        });

        executorService.shutdown();
    }
}