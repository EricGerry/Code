import java.util.*;

/*
* 末尾零的个数
* 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
* 输入描述:
* 输入为一行，n(1 ≤ n ≤ 1000)
* 输出描述:
* 输出一个整数,即题目所求
* 示例1
* 输入
* 10
* 输出
* 2
* */

public class EndZeros {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(), res = 0;
            for (int i = 5; i <= n; i *= 5) {
                res += n / i;
            }
            System.out.println(res);
        }
        in.close();
    }
}