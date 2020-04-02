import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/3 0:10
 */

/*
* 找x

输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）。

输入描述:
测试数据有多组，输入n(1<=n<=200)，接着输入n个数，然后输入x。


输出描述:
对于每组输入,请输出结果。
示例1
输入
2
1 3
0
输出
-1*/

public class LookForX {

    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int n=sc.nextInt();
            int [] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            int x=sc.nextInt();
            int index=-1;
            for(int i=0;i<n;i++)
            {
                if(arr[i]==x)
                {
                    index=i;
                }
            }
            System.out.println(index);
        }
    }

}
