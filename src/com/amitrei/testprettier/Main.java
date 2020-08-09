package com.amitrei.testprettier;
import com.amitrei.testprettier.beans.TableManager;
import com.amitrei.testprettier.beans.Title;


public class Main {


    public static void main(String[] args) {

            Book book1 = new Book(13,"Amit","Best coupon you will ever see in your life",123,321,"image.png");
            TableManager.getInstance().getTemplate("Book").setWidth(10)
                    .createRow(book1).createRow(book1).createTitle("Changing the planet!!")
                    .createRow("asfasf","asfasf","asfasf","asfasf","asfasf","asfasf","asfasf")
                    .initTable();


    }

}
