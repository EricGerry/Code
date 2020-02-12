package com.tcp;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    private static final String HOST = "localhost";
    private static final int POST = 9999;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, POST);

        InputStream is = socket.getInputStream();//获取到的是socket帮我们包装的一个输入字节流
        //缓冲字符流BufferReader/BufferWriter；字节流转化为字符流需通过InputStreamReader/OutputStreamWriter字节字符转换流来进行转换
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        PrintWriter pw = new PrintWriter(os, true);
        pw.println("hello");
    }
}
