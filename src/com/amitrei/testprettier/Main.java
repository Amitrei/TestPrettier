package com.amitrei.testprettier;
import com.amitrei.testprettier.beans.Row;
import com.amitrei.testprettier.services.TableManager;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        Book book  = new Book(13,"12341555555522","description",42,214,"ami");
        book.getStamList().put("asfas","asfsa");
        Book book2  = new Book(14,"Gorege","Best Description",10,20,"image.png");

        TableManager tableManager = TableManager.getInstance();
        tableManager.getTemplate("Book").setWidth(10).createRow(book).createRow(book2).initTable();

//        String[] template={"abcde","acbce","abcdefg"};
//        List<String> arr = Arrays.asList("123455","12345","123456");
//        Row row = new Row(0,template,arr);
//        System.out.println();


    }

}
