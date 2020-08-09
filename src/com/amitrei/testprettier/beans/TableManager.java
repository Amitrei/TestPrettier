package com.amitrei.testprettier.beans;
import com.amitrei.testprettier.services.AnnotationScanner;
import com.amitrei.testprettier.services.MethodServices;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableManager {

    private static TableManager instance = null;

    private List<Table> allTables = new ArrayList<>();

    AnnotationScanner annotationScan = new AnnotationScanner();
    private final Class<? extends Annotation> tableTemplateAnno = com.amitrei.testprettier.annotations.TableTemplate.class;
    private Set<Class<?>> allAnnotatedClasses = new HashSet<>();
    private MethodServices methodScanner = new MethodServices();

    /**
     * @Method TableManager
     * Scanning for annotations of all classes
     * then creates a new table with the template headers (getters of the annotated class).
     */

    private TableManager() {
        scanForAnnoClasses(tableTemplateAnno);
        for (Class<?> clazz : allAnnotatedClasses) {
            Table table = new Table(clazz.getSimpleName());
            table.createHeaders(convertFromListToArray(methodScanner.scanForGetters(clazz)));
            allTables.add(table);
        }

    }



    public Table createTable() {
        Table table = new Table();
        return table;
    }

    public Table getTemplate(String templateName) {
        for (Table table : allTables) {
            if (table.getTemplateName().equals(templateName)) {
                return table;
            }
        }

        return null;
    }

    private String[] convertFromListToArray(List<String> headers) {
        String[] headersArray = new String[headers.size()];
        for (int i = 0; i < headers.size(); i++) {
            headersArray[i] = headers.get(i);
        }
        return headersArray;
    }

    private void scanForAnnoClasses(Class<? extends Annotation> annotation) {
        allAnnotatedClasses = annotationScan.scanClasses(annotation);
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