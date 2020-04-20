/**
 * @Author：Eric
 * @Date：2020/4/20 21:41
 */

/*
* 求和

输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来

输入描述:
每个测试输入包含2个整数,n和m


输出描述:
按每个组合的字典序排列输出,每行输出一种组合
示例1
输入
5 5
输出
1 4<br/>2 3<br/>5
* */

import java.util.*;
public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String res = "";//用来记录被选到的数
        int sum = 0; //用来记录被选到数加起来的总和
        int[] num = new int[n];
        int j = 1;
        for (int i = 0; i < n; i++) {
            num[i] = j++;
        }
        process(num, m, res, sum, 0);
    }

    public static void process(int[] num, int m, String res, int sum, int i) {
        if (i == num.length) {
            if (sum == m) {
                //这里用trim（）方法就是去除每个输出最后的一个空格
                System.out.println(res.trim());
            }
            return;
        }
        //表示我将num[i]这个数选到了
        process(num, m, res + num[i] + " ", sum + num[i], i + 1);

        //表示我不要num[i]这个数
        process(num, m, res, sum, i + 1);
    }
}