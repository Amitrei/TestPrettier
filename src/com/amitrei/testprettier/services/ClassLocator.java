package com.amitrei.testprettier.services;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ClassLocator {
    private Set<Class<?>> locatedClasses = new HashSet<>();

    public ClassLocator() {
        File file = new File(getDirectory(this.getClass()));

        try {
            for (File innerFile : file.listFiles()) {
                scanDirectory(innerFile, "");
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());;
        }    }


    private  void scanDirectory(File file, String packageName) throws ClassNotFoundException {
        if (file.isDirectory()) {
            packageName += file.getName() + ".";

            for (File innerFile : file.listFiles()) {
                this.scanDirectory(innerFile, packageName);
            }

        }
        else{

            if (!file.getName().endsWith(".class")) {
                return;
            }

            final String className = packageName + file.getName().replace(".class", "");
            locatedClasses.add(Class.forName(className));
        }
    }

    private String getDirectory(Class<?> clazz) {
        return clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
    }

    public Set<Class<?>> getLocatedClasses() {
        return locatedClasses;
    }
}
