package com;

import com.config.MainConfig;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class test {

    @SuppressWarnings("resources")
    @Test
    public void test01(){
      AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionName = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionName){
            System.out.println(name);
        }

    }
}
