package com.config;

import com.bean.Person;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

//配置类等于配置文件
@Configuration  //告诉Spring这是一个配置类
@ComponentScans(
        value = {
        @ComponentScan(value = "com" , includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
},useDefaultFilters = false)
        }
        )

//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[] :指定扫描的时候按照什么规则排除哪些组件
//includeFilters = Filter[] :指定扫描的时候包含哪些组件
//FilterType.ANNOTATION:按照注解
//FilterType.ASSIGNABLE_TYPE:按照指定类型
//FilterType.ASPECTJ；使用ASPECTJ
//FilterType.

public class MainConfig {

    //给容器中注册一个Bean;类型为返回值的类型，id默认是方法名作为id
    @Bean("Person")
    public Person person01(){
        return new Person("lisan", 20);
    }
}
