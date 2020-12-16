package com.string;

public class StringReverseExample {
    public static void main(String[] args) {
        //Java 的反转函数 reverse() 将字符串反转
        String str = "this is Java";
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println("字符反转前："+ str);
        System.out.println("字符反转后："+ reverse);
    }
}
