import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/3/28 18:37
 */
/*
* 数字分类
给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：



A1 = 能被5整除的数字中所有偶数的和；

A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；

A3 = 被5除后余2的数字的个数；

A4 = 被5除后余3的数字的平均数，精确到小数点后1位；

A5 = 被5除后余4的数字中最大数字。

输入描述:
每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。


输出描述:
对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
若其中某一类数字不存在，则在相应位置输出“N”。
示例1
输入
13 1 2 3 4 5 6 7 8 9 10 20 16 18
输出
30 11 2 9.7 9*/
public class DigitalSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        int i = 0;
        int Num0 = 0;
        int Num1 = 0;
        int count1 = 0;
        int Num2 = 0;
        int sum3 = 0;
        int count3 = 0;
        int Num4 = 0;
        int tem = 0;
        while (i < array.length){
            array[i] = scanner.nextInt();
            i++;
        }
        for (int j = 0; j < array.length; j++){
            switch (array[j]%5){
                case 0: {
                    if (array[j]%2 == 0){
                    Num0+=array[j];
                }
                    break;
                }
                case 1:{
                   Num1 += (count1%2==0?1:-1)*array[j];
                   count1++;
                   break;
                }
                case 2:{
                    if (array[j]%5 == 2){
                        Num2 ++;
                    }
                    break;
                }
                case 3:{
                    if (array[j]%5 == 3){
                        count3++;
                        sum3 += array[j];
                    }
                    break;
                }
                case 4:{
                    if (array[j]%5 == 4){
                        tem = array[j];
                    }
                    Num4 = Num4 > tem ? Num4 :tem;
                }
            }
        }
        String Num3 = "N";
        DecimalFormat df = new DecimalFormat("#.0");
        if (count3 > 0){
            Num3 = df.format(sum3*1.0/count3);
        }
        if (Num0 == 0){
            System.out.print("N"+" ");
        }else {
            System.out.print(Num0+" ");
        }
        if (Num1 == 0){
            System.out.print("N"+" ");
        }else {
            System.out.print(Num1+" ");
        }
        if (Num2 == 0){
            System.out.print("N"+" ");
        }else {
            System.out.print(Num2+" ");
        }
        System.out.print( Num3+" ");
        if (Num4 == 0){
            System.out.print("N");
        }else {
            System.out.print(Num4);
        }

    }
}
