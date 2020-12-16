package com.string;

public class StringReplaceEmp {
    public static void main(String[] args) {
        //String 类的 replace 方法来替换字符串中的字符：
        String str = "Hello World";
        System.out.println(str.replace('H','W'));
        System.out.println(str.replaceFirst("He", "Wo"));
        System.out.println(str.replaceAll("l", "T"));
    }
}
