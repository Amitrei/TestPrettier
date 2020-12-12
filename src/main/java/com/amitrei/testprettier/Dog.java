package com.amitrei.testprettier;

public class Dog extends Animal {
    public String getDogType() {
        return dogType;
    }

    public void setDogType(String dogType) {
        this.dogType = dogType;
    }

    private String dogType;

    public Dog(String name, String sayHi, String dogType) {
        super(name, sayHi);
        this.dogType = dogType;
    }
}
