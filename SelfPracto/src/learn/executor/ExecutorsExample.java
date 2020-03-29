package com.learn.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created By MMT6540 on 17 Apr, 2018
 */
public class ExecutorsExample {
    public static void main(String[] args) {
        System.out.println("Inside: "+Thread.currentThread().getName());

        System.out.println("Creating the Executor Service");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        System.out.println("Creating a runnable");
        Runnable runnableTask1 = () -> {
            System.out.println("Inside Runnable Task1: "+Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException e){
                throw new IllegalStateException(e);
            }
        };

        Runnable runnableTask2 = () -> {
            System.out.println("Inside Runnable Task2: "+Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(4);
            }catch(InterruptedException e){
                throw new IllegalStateException(e);
            }
        };

        Runnable runnableTask3 = () -> {
            System.out.println("Inside Runnable Task3: "+Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(4);
            }catch(InterruptedException e){
                throw new IllegalStateException(e);
            }
        };

        Runnable runnableTask4 = () -> {
            System.out.println("Inside Runnable Task4: "+Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(4);
            }catch(InterruptedException e){
                throw new IllegalStateException(e);
            }
        };


        System.out.println("Submitting the Runnable to Executor");
        executorService.submit(runnableTask1);
        executorService.submit(runnableTask2);
        executorService.submit(runnableTask3);
        executorService.submit(runnableTask4);

        System.out.println("Shutting down the Executor");
        executorService.shutdown();
    }
}