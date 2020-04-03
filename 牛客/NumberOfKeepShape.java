import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/3 22:38
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
No!
* */

public class NumberOfKeepShape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (String.valueOf(n * n).endsWith( String.valueOf(n))) {
                System.out.println("Yes!");
            }
            else {
                System.out.println("No!");
            }
        }
    }
}
