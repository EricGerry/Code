
import java.util.*;
/*
* 数字颠倒
* 描述：
* 输入一个整数，将这个整数以字符串的形式逆序输出
* 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
* 输入描述:
* 输入一个int整数
* 输出描述:
* 将这个整数以字符串的形式逆序输出
* 示例1
* 输入
* 1516000
* 输出
* 0006151
* */
public class ReverseStr {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i=0;
        String res="";

        while(num!=0){
            int t1=num%10;
            int t2=num/10;
            res=res+String.valueOf(t1);
            i++;
            num=t2;
        }
        System.out.println(res);
    }

        public static void main2(String[] args){
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            StringBuffer sb = new StringBuffer(str);
            sb.reverse();
            System.out.println(sb.toString());
    }

}