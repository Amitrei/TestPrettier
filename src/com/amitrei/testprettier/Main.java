package com.amitrei.testprettier;

import com.amitrei.testprettier.beans.TableManager;
import com.amitrei.testprettier.exceptions.BeanNotFoundException;


public class Main {


    public static void main(String[] args) {


        Book harryPotter = new Book("1  ","1","1");
        Book mobyDick = new Book("1","1","1");
        Book treasureIsland = new Book("Treasure Islanaad"," Robert Lffffuis Stnson","anture");

        TableManager.getInstance(Main.class).getTemplate("Book",30)
                .createTitle("My BookStore")
                .createRow(mobyDick)
                .createRow(treasureIsland).createRow(mobyDick).initTable();





    }

}
