import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/13 18:26
 */

/*
* 进制转换

写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）


输入描述:
输入一个十六进制的数值字符串。



输出描述:
输出该数值的十进制字符串。

示例1
输入
0xA
输出
10
* */

public class DeCode {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            System.out.println(Integer.decode(str));
           // System.out.println(Integer.parseInt(str.substring(2),16));//str.substring(2)表示去除0x
        }
    }
}
