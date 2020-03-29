package com.learn.executor;

public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Started. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName() +" End!");
    }

    private void processCommand(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
