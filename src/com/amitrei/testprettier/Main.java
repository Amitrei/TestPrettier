package com.amitrei.testprettier;

import com.amitrei.testprettier.beans.Table;
import com.amitrei.testprettier.services.LocateClass;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {


    private static List<String> headers = new ArrayList<>();
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Book A  = new Book(13,"amit","desc",124,214,"ami");


        Method fieldGetter = A.getClass().getMethod("getId");
        String f = fieldGetter.invoke(A).toString();


        System.out.println(f);
        LocateClass locateClass = new LocateClass();

        for(Class<?> clazz : locateClass.getLocatedClasses()) {
            if(clazz.isAnnotationPresent(com.amitrei.testprettier.annotations.Test.class)) {

                for(Method method : clazz.getDeclaredMethods()) {
                    if(method.getName().startsWith("get")) {
                        headers.add(method.getName().substring(3));
                    }
                }



            }


        }



        String[] h1 = new String[headers.size()];
        for(int i = 0 ; i< headers.size();i++) {
            h1[i] = headers.get(i);
        }

        Table createTable = new Table(15);
        createTable.createHeaders(h1);
        createTable.createRow("Testing row #1", "Testing row #2", "Testing row #3", "Testing row #3", "Testing row #3", "Testing row #3");
        createTable.initTable();








    }

}
