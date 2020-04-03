import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/3 22:42
 */

/*
* 守形数

守形数是这样一种整数，它的平方的低位部分等于它本身。 比如25的平方是625，低位部分是25，因此25是一个守形数。 编一个程序，判断N是否为守形数。

输入描述:
输入包括1个整数N，2<=N<100。


输出描述:
可能有多组测试数据，对于每组数据，
输出"Yes!”表示N是守形数。
输出"No!”表示N不是守形数。
示例1
输入
25
4
输出
Yes!
No!*/

public class NumberOfKeepShape2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n1=sc.nextInt();
            int n2=(int)Math.pow(n1,2);//1.求出n2
            // 2.先将n2转换成字符串，用字符串的截取功能将n3截取出来，再次转换为数字
            String s1=""+n2;
            String s2=s1.substring(1);
            //当n1=2或者n1=3的时候求出来的m无法进行截取，所以我们要进行排除这个
            if(s2.length()>0) {
                int n3 = Integer.parseInt(s2);
                if (n1 == n3) {//3.n3与n1进行对比即可
                    System.out.println("Yes!");
                } else {
                    System.out.println("No!");
                }
            }else {
                System.out.println("No!");
            }
        }
    }
}
