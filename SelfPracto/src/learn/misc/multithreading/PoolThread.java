package com.learn.misc.multithreading;

public class PoolThread extends Thread{

    private BlockingQueue taskQueue = null;
    private Boolean isStopped = false;

    public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        while(!isStopped){
            Runnable runnable = (Runnable) taskQueue.dequeue();
            runnable.run();
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
