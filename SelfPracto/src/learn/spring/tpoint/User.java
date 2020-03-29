package com.learn.spring.tpoint;

public class User {
    private int id;
    private String name, email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String toString(){
        return "ID: "+id+" NAME: "+name+" EMAIL: "+email;
    }
}
