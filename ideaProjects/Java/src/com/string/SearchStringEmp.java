package com.string;

public class SearchStringEmp {
    public static void main(String[] args) {
        //String 类的 indexOf() 方法在字符串中查找子字符串出现的位置，
        // 如果存在返回字符串出现的位置（第一位为0），如果不存在返回 -1：
        String strOrig = "this is Java";
        int intIndex = strOrig.indexOf("Java");
        if(intIndex == - 1){
            System.out.println("没有找到字符串 Java");
        }else{
            System.out.println("Java 字符串位置 " + intIndex);
        }
    }
}
