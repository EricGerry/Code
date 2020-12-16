package com.string;

public class StringCompareEmp {
    public static void main(String[] args) {
        //字符串比较
        //比较返回第一个字母的差值

        String str = "hello World";
        String anotherStr = "HELLO WORLD";

        Object objStr = str;

        System.out.println(str.compareTo(anotherStr));
        System.out.println(str.compareToIgnoreCase(anotherStr));//忽略大小写
        System.out.println(str.compareTo(objStr.toString()));
    }
}
