package com.learn.spring.java8;

/**
 * Created By MMT6540 on 29 Jul, 2018
 */
@FunctionalInterface
public interface PwdEncoder {
    public String encode(String pwd, String salt);
}
