package com.amitrei.testprettier.beans;

import com.amitrei.testprettier.exceptions.BeanNotFoundException;
import com.amitrei.testprettier.services.AnnotationService;
import com.amitrei.testprettier.services.FieldService;
import com.amitrei.testprettier.services.MethodService;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableManager {

    private static TableManager instance = null;

    private List<Table> allTables = new ArrayList<>();

    private AnnotationService annotationScan;
    private final Class<? extends Annotation> tableTemplateAnno = com.amitrei.testprettier.annotations.TableTemplate.class;
    private Set<Class<?>> allAnnotatedClasses = new HashSet<>();
    private MethodService methodScanner = new MethodService();
    private FieldService fieldServices = new FieldService();

    /**
     * @Method TableManager
     * Scanning for annotations of all classes
     * then creates a new table with the template headers (getters of the annotated class).
     */


    private TableManager(Class<?> mainClass) {
        annotationScan = new AnnotationService(mainClass);
        scanForAnnoClasses(tableTemplateAnno);
        for (Class<?> clazz : allAnnotatedClasses) {
            Table table = new Table(clazz.getSimpleName(), clazz);
            table.createHeaders(convertFromListToArray(methodScanner.scanForGetters(clazz)));
            allTables.add(table);
        }

    }


    public Table getTemplate(String templateName, int width)  {


        for (Table table : allTables) {
            if (table.getTemplateName().equals(templateName)) {
                table.setWidth(width);
                return table;
            }
        }
        try {
            throw new BeanNotFoundException();
        }
        catch (BeanNotFoundException e){
            e.printStackTrace();
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
        allAnnotatedClasses = annotationScan.scanForAnnotations(annotation);
    }


    public static TableManager getInstance(Class<?> mainClass) {
        if (instance == null) {
            synchronized (TableManager.class) {
                if (instance == null) {
                    instance = new TableManager(mainClass);
                }
            }
        }
        return instance;
    }
}