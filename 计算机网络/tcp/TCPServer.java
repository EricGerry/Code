package com.tcp;

import java.awt.image.Kernel;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer {
    public static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            //阻塞，等待新的客户端连接
            Socket socket = serverSocket.accept();

            //处理这个客户连接的业务，这个业务可能会发生阻塞
            //先不考虑阻塞实现
            InputStream is = socket.getInputStream();//获取到的是socket帮我们包装的一个输入字节流
            //缓冲字符流BufferReader/BufferWriter；字节流转化为字符流需通过InputStreamReader/OutputStreamWriter字节字符转换流来进行转换
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            //1.先接受客户端传过来的数据，并打印
            //2.响应给客户端一个数据：我已接受到xxxx的消息

            String line;
            //阻塞等待客户端传来的新的一行数据
            while ((line = br.readLine()) != null){
                System.out.println("服务端接收到数据："+line);
                bw.write("我已经接收到了"+line+"消息\n");
                //需要刷新一下缓冲区，这时才会将数据发送到对端
                bw.flush();
            }
        }
    }

}
