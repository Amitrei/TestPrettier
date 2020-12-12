package com.amitrei.testprettier;

public abstract class Animal {
    private String name;
    private String sayHi;

    public Animal(String name, String sayHi) {
        this.name = name;
        this.sayHi = sayHi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSayHi() {
        return sayHi;
    }

    public void setSayHi(String sayHi) {
        this.sayHi = sayHi;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sayHi='" + sayHi + '\'' +
                '}';
    }
}

