package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class UdpClient {
    // 定义发送数据报的目的地
    public static final int DEST_PORT = 30000;

    public static final String DEST_IP = "127.0.0.1";
    // 定义每个数据报的最大大小为4K
    private static final int DATA_LEN = 4096;
    // 定义接收网络数据的字节数组
    byte[] inBuff = new byte[DATA_LEN];


    // 创建接受回复数据的DatagramPacket对象
    private DatagramPacket packet_in = new DatagramPacket(inBuff, inBuff.length);

    // 定义一个用于发送的DatagramPacket对象
    private DatagramPacket packet_out = null;



    public void start() throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {
            // 初始化发送用的DatagramSocket
            InetAddress ip = InetAddress.getByName(DEST_IP);
            packet_out = new DatagramPacket(new byte[0], 0, ip, DEST_PORT);
            // 创建键盘输入流
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数据");
            // 不断读取键盘输入
            String key =null;
            // 键盘输入字符对应的byte数组
            byte[] keyBuff = null;
            while (sc.hasNextLine()) {
                key = sc.nextLine();
                if ("exit".equals(key)) {
                    break;
                }
                // 输入的字符串→字节数组
                keyBuff = key.getBytes();
                // 设置发送用的DatagramPacket里的字节数据
                packet_out.setData(keyBuff);
                // 发送数据报
                socket.send(packet_out);
                // 读取Socket中的数据，读到的数据放在inPacket所封装的字节数组里。
                socket.receive(packet_in);
                System.out.println(new String(inBuff, 0, packet_in.getLength()));
                System.out.println("请输入数据:");
            }
            System.out.println("=== 客户端退出 ===");
        }
    }

    public static void main(String[] args) throws IOException {
        new UdpClient().start();
    }
}