package com.amitrei.testprettier;

import com.amitrei.testprettier.beans.TableManager;


public class Main {


    public static void main(String[] args) {


        Book harryPotter = new Book("Harry Potter","Jk Rowling","fantasy");
        Book mobyDick = new Book("Moby Dick","Herman Melville","fantasy");
        Book treasureIsland = new Book("Treasure Island"," Robert Louis Stevenson","adventure");

        TableManager.getInstance(Main.class).getTemplate("Book").setWidth(20)
                .createTitle("My BookStore")
                .createRow(mobyDick)
                .createRow(harryPotter)
                .createRow(treasureIsland).initTable();




    }

}
