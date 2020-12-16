package com.string;

public class StringArrayOutput {
    //输出字符串数组
    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "this";
        strArr[1] = "is";
        strArr[2] = "Java";
        for (int i = 0; i < strArr.length; i++){
            if (i != strArr.length - 1){
                System.out.print(strArr[i] + " ");
            }else {
                System.out.println(strArr[i]);
            }
        }
    }
}
