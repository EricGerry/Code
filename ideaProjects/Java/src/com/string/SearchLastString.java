package com.string;

public class SearchLastString {
    public static void main(String[] args) {
        //通过字符串函数 strOrig.lastIndexOf(StringName) 来查找子字符串 StringName 在 strOrig 出现的位置
        String strOrig = "Hello World , Hello Run Anywhere";
        int lastIndex = strOrig.lastIndexOf("Anywhere");
        if (lastIndex == - 1){
            System.out.println("没有找到字符串Anywhere");
        }else {
            System.out.println("Anywhere字符串最后出现的位置是："+lastIndex);
        }
    }
}
