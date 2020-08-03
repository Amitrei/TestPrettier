package com.amitrei.testprettier.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Table {
    private String[] template = null;
    private String[] headerContent = null;
    private String[] rowContent = null;
    private List<Row> allRows= new ArrayList<>();
    private int width=2;


    public Table(int width) {
        this.width = width;

    }


    public Table() {

    }



    // NEED TO ADD Throw Exception if headers was already made
    public void createHeaders(String... headerContent) {
        this.headerContent = headerContent;
        template=headerContent.clone();

    }


    public void createRow(String... rowContent) {
        this.rowContent = rowContent;
        allRows.add(new Row(width,template,rowContent));

    }


    public void initTable() {
        System.out.println();
        Header header = new Header(width,template,headerContent);
        initRows();


    }

    private void initRows() {
        for(int i=0;i<allRows.size();i++) {

            if(i==allRows.size()-1) {
                allRows.get(i).lastRowRender();
                continue;
            }

            allRows.get(i).rowRender();

        }
    }


    // Testing purposes
    private void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        }




}
