package com.learn.misc.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestingFuture {

    public static void main(String[] args) {
        CompletableFuture completableFuture = new CompletableFuture();
        try {
            completableFuture.complete("Here it ends");
            String result = (String) completableFuture.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
