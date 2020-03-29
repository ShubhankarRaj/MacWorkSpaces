package com.learn.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MySampleAnn {
    String name();
    String desc();
}

class MyAnnTest{
    @MySampleAnn(name = "Test Name", desc = "Description of something")
    public void testMethod(){
        //  IMPLEMENTATION
    }
}
