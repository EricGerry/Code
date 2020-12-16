package com.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public  class MyTypeFilter implements TypeFilter {

    /*
    * metadataReader:读取当前扫描类的信息
    *  metadataReaderFactory：可以获取到其他任何类的信息
    *     */

    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取到当前类的注解信息
        AnnotatedTypeMetadata annotatedTypeMetadata =  metadataReader.getAnnotationMetadata();
        //获取当前正在扫描类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("-->" + className);
        if (className.contains("er")){
            return true;
        }

        return false;
    }
}
