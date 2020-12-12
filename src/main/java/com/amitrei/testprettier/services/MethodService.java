package com.amitrei.testprettier.services;

import com.amitrei.testprettier.exceptions.NotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodService {
    FieldService fieldServices = new FieldService();

    public MethodService() {
    }



    public List<String> scanForGetters(Class<?> clazz) {


        // Scanning all fields and comparing in to the getters names to match
        List<String> headersFromGetters = new ArrayList<>();
        List<Method> allMethodsFromSuperClasses = getAllGettersFromSuperClass(clazz, new ArrayList<Method>());
        for (Method method : allMethodsFromSuperClasses) {
            boolean isGettersMatchField = fieldServices.scanAllFields(clazz).contains(method.getName().substring(3).toLowerCase());
            if (method.getName().startsWith("get") && isGettersMatchField) {
                headersFromGetters.add(method.getName().substring(3));
            }


        }

        if (headersFromGetters.isEmpty()) {
            try {
                throw new NotFoundException("Cannot find any getters that matches the class fields, make sure the getter method starts with 'get'");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }

        return headersFromGetters;
    }

    public List<Method> scanForGetters(Object obj) {
        // Scanning all fields and comparing in to the getters names to match
        List<Method> allGetters = new ArrayList<>();
        List<Method> allMethodsFromSuperClasses = getAllGettersFromSuperClass(obj.getClass(), new ArrayList<Method>());
        for (Method method : allMethodsFromSuperClasses) {
            boolean isGettersMatchField = fieldServices.scanAllFields(obj.getClass()).contains(method.getName().substring(3).toLowerCase());
            if (method.getName().startsWith("get") && isGettersMatchField) {
                allGetters.add(method);
            }


        }

        if (allGetters.isEmpty()) {
            try {
                throw new NotFoundException("Cannot find any getters that matches the class fields, make sure the getter method starts with 'get'");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }

        return allGetters;
    }

    public List<String> methodInvoker(List<Method> methodGettersList, Object invokedOnObj) {
        List<String> gettersInvoked = new ArrayList<>();
        for (Method method : methodGettersList) {
            try {
                gettersInvoked.add(method.invoke(invokedOnObj).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


        return gettersInvoked;
    }

    private List<Method> getAllGettersFromSuperClass(Class<?> clazz, List<Method> allMethods) {

        if (clazz.getSuperclass() == null) {
            return allMethods;
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().toLowerCase().startsWith("get"))
                allMethods.add(method);
        }
        return getAllGettersFromSuperClass(clazz.getSuperclass(), allMethods);
    }

}
