package com.learn.executor;

import java.lang.reflect.Array;

public class ReversingAString {
    public static void main(String[] args)
    {
        String str="My name is  Saiqua Khan";
        System.out.println("INPUT STRING - "+str);
        String[] str1=str.split("\\s\\s",0);
        for(int i=0;i<str1.length;i++){
            System.out.println(str1[i]);
        }
        String[] str2=str.split("\\s",0);
        for(int i=0;i<str2.length;i++){
            System.out.println(str2[i]);
    }
        for(int j=str2.length-1;j>=0;j--){
            System.out.print(str2[j]+" ");
        }

        System.out.println("OUTPUT STRING - ");

}}
