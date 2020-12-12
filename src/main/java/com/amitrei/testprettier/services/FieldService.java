package com.amitrei.testprettier.services;

import com.amitrei.testprettier.exceptions.NotFoundException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldService {


    public List<String> scanAllFields(Class<?> clazz) {


        // No Fields declared
            List<String> allFieldsIncludeSuperClass = checkForFieldsInSuperClass(clazz, new ArrayList<String>());
            if (allFieldsIncludeSuperClass.size() <= 0) {
                try {
                    throw new NotFoundException("Couldn't find any fields not in class or super classes.");
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            }


        return allFieldsIncludeSuperClass;
    }

    public List<String> scanAllFields(Object obj) {

        // No Fields declared
        List<String> allFieldsIncludeSuperClass = checkForFieldsInSuperClass(obj.getClass(), new ArrayList<String>());
        if (allFieldsIncludeSuperClass.size() <= 0) {
            try {
                throw new NotFoundException("Couldn't find any fields not in class or super classes.");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }


        return allFieldsIncludeSuperClass;
    }


    private List<String> checkForFieldsInSuperClass(Class<?> clazz, List<String> allFields) {
        if (clazz.getSuperclass() == null)
            return allFields;

        for (Field field : clazz.getDeclaredFields()) {
            allFields.add(field.getName().toLowerCase());
        }

        return checkForFieldsInSuperClass(clazz.getSuperclass(), allFields);
    }
}
