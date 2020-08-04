package com.amitrei.testprettier;

import com.amitrei.testprettier.annotations.TableTemplate;
import com.amitrei.testprettier.beans.Table;
import com.amitrei.testprettier.beans.TableManager;
import com.amitrei.testprettier.services.AnnotationScanner;
import com.amitrei.testprettier.services.MethodScanner;

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


        TableManager tableManager = TableManager.getInstance();
        tableManager.getTable("Book").createRow(A).initTable();














    }

}
