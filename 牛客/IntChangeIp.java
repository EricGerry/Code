/**
 * @Author：Eric
 * @Date：2020/4/3 0:16
 */

import java.util.Scanner;

/**
 * IP地址转十进制数 十进制数转IP地址
 *
 * @author huadekai
 *
 */

/*
* 整数与IP地址间的转换

原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001
组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。



的每段可以看成是一个0-255的整数，需要对IP地址进行校验








输入描述:
输入
1 输入IP地址
2 输入10进制型的IP地址



输出描述:
输出
1 输出转换成10进制的IP地址
2 输出转换后的IP地址

示例1
输入
10.0.3.193
167969729
输出
167773121
10.3.3.193*/

public class IntChangeIp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            // 判断输入是IP地址还是十进制数
            if (str.contains(".")) {
                String[] arr = str.split("\\.");
                long[] ip = new long[arr.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    ip[i] = Long.parseLong(arr[i]);
                    String a = Long.toBinaryString(ip[i]);
                    //转成8位二进制 利用String.format()控制格式
                    String temp = String.format("%08d", Long.parseLong(a));
                    sb.append(temp);
                }
                long output = Long.parseLong(sb.toString(), 2);
                System.out.println(output);
            } else {
                String binaryChuan = Long.toBinaryString(Long.parseLong(str));
                int len = binaryChuan.length();
                StringBuilder sb = new StringBuilder(binaryChuan);
                // 不足32位的前面补0
                for (int i = 0; i < 32 - len; i++) {
                    sb.insert(0, "0");
                }
                String fin = sb.toString();
                long a = Long.valueOf(fin.substring(0, 8), 2);
                long b = Long.valueOf(fin.substring(8, 16), 2);
                long c = Long.valueOf(fin.substring(16, 24), 2);
                long d = Long.valueOf(fin.substring(24, 32), 2);
                System.out.println(a + "." + b + "." + c + "." + d);
            }
        }
    }
}