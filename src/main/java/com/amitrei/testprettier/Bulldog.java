package com.amitrei.testprettier;

import com.amitrei.testprettier.annotations.TableTemplate;

@TableTemplate
public class Bulldog extends Dog {
    private String bulldogName;

    public Bulldog(String name, String sayHi, String dogType, String bulldogName) {
        super(name, sayHi, dogType);
        this.bulldogName = bulldogName;

    }

    public String getBulldogName() {
        return bulldogName;
    }
}
