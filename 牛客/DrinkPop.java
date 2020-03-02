/*
* 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），
* 表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
* 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
* 输入
* 3
* 10
* 81
* 0
* 输出
* 1
* 5
* 40*/
//递归方法
import java.util.*;
public class DrinkPop {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n;
        while(sc.hasNext())
        {
            n=sc.nextInt();
            System.out.println(Drink(n));
        }

    }

    public static int Drink(int n)
    {
        if(n<=0)
            return 0;
        else if(n==3)
            return 1;
        else if(n==2)
            return 1;
        else//此时表明对应为3的倍数，递归
        {
            int h=0;
            h=n/3;
            return h+Drink(n-3*h+h);
        }


    }
}