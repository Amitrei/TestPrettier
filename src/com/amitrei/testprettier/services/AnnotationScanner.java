package com.amitrei.testprettier.services;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public class AnnotationScanner {
    private Set<Class<?>> allClasses;
    private ClassLocator locateClass = new ClassLocator();

    private Set<Class<?>> allAnnotatedClasses=new HashSet<>();

    public AnnotationScanner() {
        this.allClasses=locateClass.getLocatedClasses();
    }


    public Set<Class<?>> scanClasses(Class<? extends Annotation> annotationClazz) {
        for(Class<?> clazz : locateClass.getLocatedClasses()) {
            if(clazz.isAnnotationPresent(annotationClazz)) {
                allAnnotatedClasses.add(clazz);
                }
            }
        return allAnnotatedClasses;
    }



//      for(Method method : clazz.getDeclaredMethods()){
//              if(method.getName().startsWith("get")){
//              headers.add(method.getName().substring(3));
//              }
//              }

}
