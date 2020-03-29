package com.learn.spring.factory;

public class A {
    private static final A obj = new A();

    private A(){
        System.out.println("Private Constructor");
    }

    public static A getA() {
        System.out.println("Inside Factory Method");
        return obj;
    }

    public void msg(){
        System.out.println("Hello Message!");
    }
}
