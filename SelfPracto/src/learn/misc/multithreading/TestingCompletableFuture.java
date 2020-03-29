package com.learn.misc.multithreading;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestingCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.println("Ruuning a task in PARALLEL");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        newMain();
        thenAccept();
    }

    public static void newMain() {
        CompletableFuture future = CompletableFuture.supplyAsync(() ->
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Seems like I Can return Anything";
        }).thenApply(message -> "MESSAGE:" + message);

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void thenAccept() {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> "Testing THENACCPT");
        CompletableFuture res = completableFuture.thenAccept(val -> System.out.println("So... we are "+val));
    }
}
