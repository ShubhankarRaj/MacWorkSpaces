package com.learn.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created By MMT6540 on 17 Apr, 2018
 */
public class ScheduledExecutorPeriodic {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Executing Task At "+System.nanoTime());
        };

        System.out.println("Scheduling Task every two Seconds");
        scheduledExecutorService.scheduleAtFixedRate(task,0,2, TimeUnit.SECONDS);
    }
}