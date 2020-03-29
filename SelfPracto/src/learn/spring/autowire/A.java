package com.learn.spring.autowire;

public class A {
    B b1;
    A(){
        System.out.println("A obj is created!!");
    }

    public B getB() {
        return b1;
    }

    public void setB(B b1) {
        this.b1 = b1;
    }

    void print(){
        System.out.println("Hello!! from A!");
    }

    void display(){
        print();
        b1.print();
    }
}
