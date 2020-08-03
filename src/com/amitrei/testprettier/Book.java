package com.amitrei.testprettier;

import com.amitrei.testprettier.annotations.Test;

@Test
public class Book {
    private int id;
    private String name;
    private String description;
    private int start_date;
    private int end_date;
    private String image;


    public Book(int id, String name, String description, int start_date, int end_date, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStart_date() {
        return start_date;
    }

    public int getEnd_date() {
        return end_date;
    }

    public String getImage() {
        return image;
    }
}


