package com.file;

import java.io.*;

public class OperateFile {
    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("createJavaFile.txt"));
            out.write("this is a Java file!");
            out.close();
            System.out.println("文件创建成功");
            BufferedReader in = new BufferedReader(new FileReader("createJavaFile.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            System.out.println(str);
        } catch (IOException e) {

        }
    }
}