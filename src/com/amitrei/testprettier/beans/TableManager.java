package com.amitrei.testprettier.beans;

import com.amitrei.testprettier.services.AnnotationScanner;
import com.amitrei.testprettier.services.MethodScanner;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableManager {

    private static TableManager instance = null;

    private List<Table> allTables = new ArrayList<>();

    AnnotationScanner annotationScan = new AnnotationScanner();
    private Class<? extends Annotation> tableTemplateAnno = com.amitrei.testprettier.annotations.TableTemplate.class;
    private Set<Class<?>> allAnnotatedClasses = new HashSet<>();
    private MethodScanner methodScanner = new MethodScanner();

    private TableManager() {
        scanForAnnoClasses(tableTemplateAnno);
        for (Class<?> clazz : allAnnotatedClasses) {
            Table table = new Table(clazz.getSimpleName());
            table.createHeaders(convertFromListToArray(methodScanner.scanForGetters(clazz)));
            allTables.add(table);
        }

    }

    public Table getTable(String templateName) {
        for (Table table : allTables) {
            if (table.getTemplateName().equals(templateName)) {
                return table;
            }
        }

        return null;
    }

    public String[] convertFromListToArray(List<String> headers) {
        String[] headersArray = new String[headers.size()];
        for (int i = 0; i < headers.size(); i++) {
            headersArray[i] = headers.get(i);
        }
        return headersArray;
    }

    public void scanForAnnoClasses(Class<? extends Annotation> annotation) {
        allAnnotatedClasses = annotationScan.scanClasses(annotation);
    }

    public List<Table> getAllTables() {
        return allTables;
    }


    public static TableManager getInstance() {
        if (instance == null) {
            synchronized (TableManager.class) {
                if (instance == null) {
                    instance = new TableManager();
                }
            }
        }
        return instance;
    }
}