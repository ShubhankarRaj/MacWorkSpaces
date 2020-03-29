package com.learn.misc.multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private BlockingQueue taskQueue = null;
    private List<PoolThread> threadPool = new ArrayList<>();

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue = new BlockingQueue(maxNoOfTasks);
        for(int i = 0; i < noOfThreads; i++){
            threadPool.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threadPool){
            thread.start();
        }


    }
}
