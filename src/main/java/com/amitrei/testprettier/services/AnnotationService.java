package com.amitrei.testprettier.services;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public class AnnotationService {
    private Set<Class<?>> allClasses;
    private ClassService locateClass;
    private Set<Class<?>> allAnnotatedClasses=new HashSet<>();

    public AnnotationService(Class<?> clazz) {
        locateClass = new ClassService(clazz);
 this.allClasses=locateClass.getLocatedClasses();
    }


    public Set<Class<?>> scanForAnnotations(Class<? extends Annotation> annotationClazz) {
        for(Class<?> clazz : locateClass.getLocatedClasses()) {
            if(clazz.isAnnotationPresent(annotationClazz)) {
                allAnnotatedClasses.add(clazz);
                }
            }
        return allAnnotatedClasses;
    }


}
