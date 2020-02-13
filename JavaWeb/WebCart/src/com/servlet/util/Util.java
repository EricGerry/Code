package com.servlet.util;

import com.servlet.bean.Book;

import java.util.HashMap;
import java.util.Map;

public class Util {
    private static Map<String, Book> books= new HashMap<>();
    static {
       books.put ("1",new Book("1", "java快速入门", 64, "001"));
       books.put ("2",new Book("2", "java进阶之路", 56, "002"));
       books.put ("3",new Book("3", "java高手速成", 84, "003"));
       books.put ("4",new Book("4", "java编程之道", 54, "004"));

    }
    public static Map<String, Book> findAllBooks(){
        return books;
    }
    public static Book findBookById(String id){
        return books.get(id);
    }
}
