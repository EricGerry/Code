package com.JDBC;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        //初始化驱动
        try {
            //驱动类com.mysql.jdbc.Driver
            //就在 mysql-connector-java-5.0.8-bin.jar中
            //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库加载成功");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2Java?characterEncoding=UTF-8","root","admin");
            System.out.println("链接成功，获取链接对象："+ c);
            s = c.createStatement();
            System.out.println("获取到statement对象："+ s);
            String sql = "insert into hero values(null, " + "'角色8'" + "," + 313.0f +"," + 20 +" )";
            s.execute(sql);
            System.out.println("插入成功");
            String name =  "dashen";
            String password = "thisispassword   ";
            String sql_login = "select * from user where name  = ' "+ name +" 'and password = '" + password +"'";
            ResultSet re = s.executeQuery(sql_login);
            String sql_1= "insert into hero values(null,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql_1);
            p.setString(1, "提莫");
            p.setFloat(2, 324.0F);
            p.setInt(3,87);
            if (re.next()){
                System.out.println("账号密码正确");
            }else {
                System.out.println("账号密码错误");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null){
                try {
                    s.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (c != null){
                try {
                    c.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
