package com.amitrei.testprettier.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MethodScanner {
    private List<String> headersFromGetters = new ArrayList<>();

    public MethodScanner() {
    }


    public List<String> scanForGetters(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().startsWith("get")) {
                headersFromGetters.add(method.getName().substring(3));
            }
        }

        return headersFromGetters;
    }
}
