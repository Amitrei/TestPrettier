package com.amitrei.testprettier.beans;

import com.amitrei.testprettier.interfaces.Rows;
import com.amitrei.testprettier.interfaces.TableParts;
import com.amitrei.testprettier.services.MethodServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Table {


    private String templateName;
    public String[] template;
    public String[] headerContent;
    private String[] rowContent;
    private List<Rows> allRows= new ArrayList<>();
    private int width=10;
    private MethodServices methodScanner;
    private List<TableParts> allParts = new ArrayList<>();



    protected Table(String templateName) {
        this.setTemplateName(templateName);
    }

    public Table() {

    }



    // NEED TO ADD Throw Exception if headers was already made

    public Table createHeaders(String... headerContent) {
        this.headerContent = headerContent;
        template=headerContent.clone();
        return this;
    }

    public Table createRow(String... rowContent) {
        this.rowContent = rowContent;
        List<String> rowContentAsList = Arrays.asList(rowContent);
        allRows.add(new Row(width,template,rowContentAsList));
        return this;

    }

    public Table createTitle(String titleContent) {
        Title title = new Title(template,width,titleContent);
        return this;

    }

    public Table createRow(Object object) {
        methodScanner= new MethodServices();
        List<String>allGettersResults=methodScanner.methodInvoker(methodScanner.scanForGetters(object));
        this.rowContent =  convertFromListToArray(allGettersResults);
        allRows.add(new Row(width,template,allGettersResults));
        return this;

    }



    public void initTable() {

        System.out.println();
        Header header = new Header(width,template,headerContent);
        initRows();
        // Clearing the rows after each init to prevent the row stick with the table template as you create a new one.
        allRows.clear();


    }

    private void initRows() {
        for(int i=0;i<allRows.size();i++) {

            if(i==allRows.size()-1) {
                allRows.get(i).endRender();
                continue;
            }

            allRows.get(i).middleRender();

        }
    }



    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Table setWidth(int width) {
        this.width = width;
        return this;
    }

    private String[] convertFromListToArray(List<String> headers) {
        String[] headersArray = new String[headers.size()];
        for (int i = 0; i < headers.size(); i++) {
            headersArray[i] = headers.get(i);
        }
        return headersArray;
    }


}
