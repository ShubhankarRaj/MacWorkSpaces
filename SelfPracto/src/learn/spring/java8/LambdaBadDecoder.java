package com.learn.spring.java8;

/**
 * Created By MMT6540 on 29 Jul, 2018
 */
public class LambdaBadDecoder implements PwdEncoder{
    public PwdEncoder makeBadEncoder(){
        return (password, salt) -> password.toUpperCase();
    }


    @Override
    public String encode(String pwd, String salt) {
        return null;
    }
}