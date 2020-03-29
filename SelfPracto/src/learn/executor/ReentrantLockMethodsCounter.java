package com.learn.executor;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By MMT6540 on 19 Apr, 2018
 */
public class ReentrantLockMethodsCounter {
    private final ReentrantLock lock = new ReentrantLock();
    private AtomicInteger countAtomic = new AtomicInteger();

    private int count = 0;

    public int incrementAndGet(){
        //  Check if the lock is CURRENTLY acquired by any thread
        System.out.println("IsLocked: "+lock.isLocked());



        //  Check if the lock is acquired by current thread
        System.out.println("IsHealdByCurrentThread : "+lock.isHeldByCurrentThread());

        //  Try to acquire the lock
        boolean isAcquired = lock.tryLock();
        System.out.println("Lock Acquired : "+isAcquired+" \n");

        if(isAcquired) {
            try {
                Thread.sleep(2000);
                count = count + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        return count;
    }
}
