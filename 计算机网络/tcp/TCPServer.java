package com.tcp;

import java.awt.image.Kernel;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.*;

public class TCPServer {
    private static final int PORT = 9999;
    /*
     * 原生线程池创建方式：
     * 1.参数1： 核心线程数（正式工，启动线程池就运行这个数量的线程）
     * 参数2：最大线程数（正式工+临时工）
     * 参数3+4：一定数量的时间+时间单位，在时间内，临时工的线程没有任务处理，就把临时工解雇掉（关闭线程）
     * 参数5：无边界的工作队列
     * 参数6：代表任务数量超过最大值，线程池应该怎么做*/
    private static final ThreadPoolExecutor POOL = new ThreadPoolExecutor(2,Integer.MAX_VALUE,
            30, TimeUnit.SECONDS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.CallerRunsPolicy());
    //    //有新任务进来需要处理，此时正式线程空置，就让正式工处理
    //    //否则让临时工，如果都没有空闲，就创建新的线程处理

    //单线程池，只有一个正式工
    //private static final ExecutorService EXE = Executors.newSingleThreadExecutor();
    //可缓存的线程池，正式工编制为0，，所有线程都是临时工
    //private static final ExecutorService EXE = Executors.newCachedThreadPool();
    //定时任务的线程池
    //private static final ExecutorService EXE = Executors.newScheduledThreadPool();
    //固定大小的线程池
    //private static final ExecutorService EXE = Executors.newFixedThreadPool();

    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            //阻塞，等待新的客户端连接
            Socket socket = serverSocket.accept();
            POOL.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //处理这个客户连接的业务，这个业务可能会发生阻塞
                        //先不考虑阻塞实现
                        InputStream is = socket.getInputStream();//获取到的是socket帮我们包装的一个输入字节流
                        //缓冲字符流BufferReader/BufferWriter；字节流转化为字符流需通过InputStreamReader/OutputStreamWriter字节字符转换流来进行转换
                        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                        OutputStream os = socket.getOutputStream();
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                        //自动刷新
                        PrintWriter pw = new PrintWriter(bw, true);
                        //1.先接受客户端传过来的数据，并打印
                        //2.响应给客户端一个数据：我已接受到xxxx的消息

                        String line;
                        //阻塞等待客户端传来的新的一行数据
                        while ((line = br.readLine()) != null) {
                            System.out.println("服务端接收到数据：" + line);
                            pw.println("我已经接收到了" + line + "消息\n");
                            //需要刷新一下缓冲区，这时才会将数据发送到对端

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}


