package com.amitrei.testprettier.beans;

import com.amitrei.testprettier.beans.Header;
import com.amitrei.testprettier.beans.Row;
import com.amitrei.testprettier.exceptions.MultipleTitlesException;
import com.amitrei.testprettier.interfaces.Rows;
import com.amitrei.testprettier.interfaces.TableParts;
import com.amitrei.testprettier.services.MethodService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Table {


    private String templateName;
    private String[] template;
    private String[] headerContent;
    private String[] rowContent;
    private List<Rows> allRows = new ArrayList<>();
    private int width = 10;
    private MethodService methodScanner;
    private List<TableParts> allParts = new ArrayList<>();
    private Class<?> headerClass;
    private com.amitrei.testprettier.beans.Title title;


    protected Table(String templateName, Class<?> headerClass) {
        this.setTemplateName(templateName);
        this.headerClass = headerClass;
    }

    protected Table() {

    }


    protected Table createHeaders(String... headerContent) {
        this.headerContent = headerContent;
        template = headerContent.clone();
        return this;
    }


    // Free content row
    // TODO adding a if statment if header size not equal to rowContent size ( user entered less row content then headers )
//    public Table createRow(String... rowContent) {
//        this.rowContent = rowContent;
//        List<String> rowContentAsList = Arrays.asList(rowContent);
//        allRows.add(new Row(width,template,rowContentAsList));
//
//        return this;
//
//    }
    public Table createTitle(String titleContent) {
        // Already set a title
        if (title != null) {

            try {
                throw new MultipleTitlesException();
            } catch (MultipleTitlesException e) {
                e.printStackTrace();
            } finally {
                return this;

            }
        }
        this.title = new Title(template, width, titleContent);

        return this;

    }



    public Table createRow(Object object) {
        if (!object.getClass().equals(headerClass)) throw new IllegalArgumentException("Not the same class");
        methodScanner = new MethodService();
        List<String> allGettersResults = methodScanner.methodInvoker(methodScanner.scanForGetters(object),object);
        this.rowContent = convertFromListToArray(allGettersResults);
        allRows.add(new Row(width, template, allGettersResults));
        return this;

    }


    public void initTable() {

        System.out.println();
        Header header = new Header(width, template, headerContent);
        initRows();
        // Clearing the rows after each init to prevent the row stick with the table template as you create a new one.
        allRows.clear();


    }

    private void initRows() {
        for (int i = 0; i < allRows.size(); i++) {

            if (i == allRows.size() - 1) {
                allRows.get(i).endRender();
                continue;
            }

            allRows.get(i).middleRender();

        }
    }


    protected String getTemplateName() {
        return templateName;
    }

    protected void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    protected Table setWidth(int width) {
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


    protected void setHeaderClass(Class<?> headerClass) {
        this.headerClass = headerClass;
    }
}
