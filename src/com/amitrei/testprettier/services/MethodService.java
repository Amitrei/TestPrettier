package com.amitrei.testprettier.services;

import com.amitrei.testprettier.exceptions.NotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodService {
    Object readRowFromObj;
    FieldService fieldServices = new FieldService();

    public MethodService() {
    }

    /**
     * @return - list of all getters names that found matched
     * @Method - scanning for getters at class and checking if getters matching the fields
     */

    public List<String> scanForGetters(Class<?> clazz) {

        // No Fields declared
        if (clazz.getDeclaredFields().length <= 0) {
            try {
                throw new NotFoundException("Cannot find any fields in the class");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }




        List<String> headersFromGetters = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            boolean isGettersMatchField = fieldServices.scanAllFields(clazz).contains(method.getName().substring(3).toLowerCase());
            if (method.getName().startsWith("get") && isGettersMatchField) {
                headersFromGetters.add(method.getName().substring(3));
            }


        }

        if(headersFromGetters.isEmpty()){
            try {
                throw new NotFoundException("Cannot find any getters that matches the class fields, make sure the getter method starts with 'get'");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }

        return headersFromGetters;
    }

    public List<Method> scanForGetters(Object obj) {
        readRowFromObj = obj;
        List<Method> methodList = new ArrayList<>();
        for (Method method : obj.getClass().getDeclaredMethods()) {
            boolean isGettersMatchField = fieldServices.scanAllFields(obj).contains(method.getName().substring(3).toLowerCase());

            if (method.getName().startsWith("get") && isGettersMatchField) {
                methodList.add(method);
            }
        }
        return methodList;
    }

    public List<String> methodInvoker(List<Method> methodList) {
        List<String> gettersInvoked = new ArrayList<>();
        for (Method method : methodList) {
            Method fieldGetter = null;
            try {
                fieldGetter = readRowFromObj.getClass().getMethod(method.getName());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                gettersInvoked.add(fieldGetter.invoke(readRowFromObj).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        return gettersInvoked;
    }


}
