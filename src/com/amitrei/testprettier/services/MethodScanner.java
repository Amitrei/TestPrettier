package com.amitrei.testprettier.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MethodScanner {
    private List<String> headersFromGetters = new ArrayList<>();
    Object readRowFromObj;

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

    public List<Method> scanForGetters(Object obj) {
        readRowFromObj=obj;
        List<Method> methodList = new ArrayList<>();
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("get")) {
                methodList.add(method);
            }
        }
        return methodList;
    }

    public List<String> methodInvoker(List<Method> methodList) {
        List<String> gettersInvoked = new ArrayList<>();
        for(Method method : methodList) {
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
