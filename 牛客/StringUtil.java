/**
 * @Author：Eric
 * @Date：2020/3/19 18:52
 */
/*
* 尼科彻斯定理
* 热度指数：16273时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M
* 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
* 例如：
* 1^3=1
* 2^3=3+5
* 3^3=7+9+11
* 4^3=13+15+17+19
* 接口说明
* 原型：
* 功能: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
* 原型：
*     int GetSequeOddNum(int m,char * pcSequeOddNum);
* 输入参数：
*    int m：整数(取值范围：1～100)
* 返回值：
*  m个连续奇数(格式：“7+9+11”);
* public String GetSequeOddNum(int m)
*        {
*        //在这里实现功能
*         return null;
*         }
*        输入描述:
*        输入一个int整数
*         输出描述:
*         输出分解后的string
*         示例1
*         输入
*         6
*         输出
*        31+33+35+37+39+41
                */
import java.util.*;
import java.io.*;

public class StringUtil {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            scanner.nextLine();
            getString(input);
        }
        scanner.close();
    }

    public static void getString(int input) {
        // first Num format首项 a = m*(m-1)+1
        int curNum = input * (input - 1) + 1;
        StringBuffer sBuffer = new StringBuffer();
        // build string
        for (int i = 0; i < input; i++) {
            if (i == input - 1) {
                sBuffer.append(curNum);
            }
            else {
                sBuffer.append(curNum + "+");
            }
            curNum += 2;
        }
        System.out.println(sBuffer);
    }
}