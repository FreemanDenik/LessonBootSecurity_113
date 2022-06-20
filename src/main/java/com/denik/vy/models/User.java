package com.denik.vy.models;

public class User {
    private int id;
    private String name;
    private String lastname;

    private byte age;

    public User(String name, String lastname, byte age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Lastname: %s, Age %d",this.name, this.lastname, this.age);
    }
}
