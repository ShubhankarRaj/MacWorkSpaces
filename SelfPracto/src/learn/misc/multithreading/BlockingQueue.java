package com.learn.misc.multithreading;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List queue = new LinkedList();
    private int limit = 10;

    public BlockingQueue(int limit){
        this.limit = limit;
    }

    public synchronized void enqueue(Object item){
        while(this.queue.size() == this.limit){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(this.queue.size() == 0){
            notifyAll();
        }
        this.queue.add(item);
    }

    public synchronized Object dequeue(){
        while(this.queue.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }
        return this.queue.remove(0);
    }
}
