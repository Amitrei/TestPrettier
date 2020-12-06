package com.amitrei.testprettier.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldService {


    public List<String> scanAllFields(Class<?> clazz) {

        List<String> allFields = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            allFields.add(field.getName().toLowerCase());
        }

        return allFields;
    }

    public List<String> scanAllFields(Object obj) {

        List<String> allFields = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            allFields.add(field.getName().toLowerCase());
        }

        return allFields;
    }
}
