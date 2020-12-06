package com.amitrei.testprettier.services;

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
     * @Method - scanning for getters at class and checking if getters matching the fields
     * @return - list of all getters names that found matched
     */

    public List<String> scanForGetters(Class<?> clazz) {

        List<String> headersFromGetters = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            boolean isGettersMatchField = fieldServices.scanAllFields(clazz).contains(method.getName().substring(3).toLowerCase());
            if (method.getName().startsWith("get") && isGettersMatchField) {
                headersFromGetters.add(method.getName().substring(3));
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
