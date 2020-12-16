package com;

import com.bean.Person;
import com.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
   /*     ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
        Person bean = (Person) applicationContext.getBean("Person");
        System.out.println(bean);*/
        ApplicationContext applicationContext1 =  new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean1 = (Person) applicationContext1.getBean(Person.class);
        System.out.println(bean1);
    }

}
