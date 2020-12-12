package com.amitrei.testprettier.exceptions;

public class MultipleTitlesException extends Exception{

    public MultipleTitlesException() {
        super("Multiple title exception make sure you used only one title at a single table.");
    }
}
