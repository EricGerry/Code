import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/19 12:41
 */

/*
*连续最大和

一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3

输入描述:
输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。


输出描述:
所有连续子数组中和最大的值。
示例1
输入
3 -1 2 1
输出
3*/

public class ContinuousMaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++){
                num[i] = scanner.nextInt();
            }
            int sum = 0;
            int max = num[0];
            for (int i = 0; i < num.length; i++){
                if (sum >= 0){
                    sum += num[i];
                }else {
                    sum = num[i];
                }
            }
            max = sum > max ? sum : max;
            System.out.println(max);
        }
    }
}
