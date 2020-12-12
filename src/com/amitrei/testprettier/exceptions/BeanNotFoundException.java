package com.amitrei.testprettier.exceptions;

public class BeanNotFoundException extends Exception {

    public BeanNotFoundException() {
        super("Java object was not found, make sure you annotated the class with @TableTemplate and wrote the name correctly ");
    }
}
