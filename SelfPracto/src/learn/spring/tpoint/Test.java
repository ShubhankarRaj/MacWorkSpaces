package com.learn.spring.tpoint;

public class Test {
    static
    {
        System.out.println("Executing Static Block.");
    }
    public final int param=20;

    public int getParam(){
        return param;
    }
}
