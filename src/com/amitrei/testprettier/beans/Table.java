package com.amitrei.testprettier.beans;

import com.amitrei.testprettier.services.MethodScanner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Table {


    private String templateName;
    public String[] template = null;
    public String[] headerContent = null;
    private String[] rowContent = null;
    private List<Row> allRows= new ArrayList<>();
    private int width=10;
    private MethodScanner methodScanner;


    public Table(int width) {
        this.width = width;

    }

    public Table(String templateName) {
        this.setTemplateName(templateName);
    }

    public Table() {

    }



    // NEED TO ADD Throw Exception if headers was already made

    public void createHeaders(String... headerContent) {
        this.headerContent = headerContent;
        template=headerContent.clone();

    }

    public Table createRow(String... rowContent) {
        this.rowContent = rowContent;
        allRows.add(new Row(width,template,rowContent));
        return this;

    }


    public Table createRow(Object object) {
        methodScanner= new MethodScanner();
        List<String>allGettersResults=methodScanner.methodInvoker(methodScanner.scanForGetters(object));
        this.rowContent =  convertFromListToArray(allGettersResults);
        allRows.add(new Row(width,template,rowContent));
        return this;

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

    public void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        }
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private String[] convertFromListToArray(List<String> headers) {
        String[] headersArray = new String[headers.size()];
        for (int i = 0; i < headers.size(); i++) {
            headersArray[i] = headers.get(i);
        }
        return headersArray;
    }


}
