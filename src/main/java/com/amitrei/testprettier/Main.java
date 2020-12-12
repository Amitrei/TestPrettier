package com.amitrei.testprettier;

import com.amitrei.testprettier.beans.TableManager;
import com.amitrei.testprettier.exceptions.BeanNotFoundException;
import com.amitrei.testprettier.services.MethodService;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static List<Method> getAllFields(Class<?> clazz,List<String> allFields,List<Method> allGetMethods){
        if(clazz.getSuperclass()==null) {
            return allGetMethods;
        }

        for(Field field : clazz.getDeclaredFields()){
            System.out.println(field.getName());
            for(Method method : clazz.getDeclaredMethods()){
                if(method.getName().startsWith("get") && method.getName().toLowerCase().contains(field.getName().toLowerCase())) {
                    allGetMethods.add(method);
                }
            }
        }


        return getAllFields(clazz.getSuperclass(),allFields,allGetMethods);
    }

    public static void main(String[] args) {


        Book harryPotter = new Book("1  ","1","1");
        Book mobyDick = new Book("1","1","1");
        Book treasureIsland = new Book("Treasure Islanaad"," Robert Lffffuis Stnson","anture");
//        Bulldog dog = new Bulldog("Woffy","woof woof","Bulldog","bulldogName");

       TableManager.getInstance(Main.class).getTemplate("Book",30)
               .createTitle("My BookStore")
               .createRow(treasureIsland)
               .initTable();









    }

}
