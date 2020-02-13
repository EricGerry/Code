package com.servlet.util;

import com.servlet.bean.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Query {

    private static Map<String, Book> books= new HashMap<>();
    static  {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            try {
                // 创建数据库连接Connection
                connection = DBUtil.getConnection2();
                // 根据数据库连接创建操作命令对象Statement
                statement = connection.createStatement();
                String sql = "select id,name,price,author from book_cart.book_dao";
                // 操作命令对象执行sql语句，返回结果集resultSet
                // resultSet类似  List<Map<String, Object>>
                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    String author= resultSet.getString("author");
                    books.put(id,new Book(id,name,price,author));

                }
            } finally {
                // 释放资源
                DBUtil.close(connection, statement, resultSet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Map<String, Book> findAllBooks(){
        return books;
    }
    public static Book findBookById(String id){
        return books.get(id);
    }
}
