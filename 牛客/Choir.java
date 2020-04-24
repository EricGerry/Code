import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/24 22:17
 */

/*合唱团

有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？

输入描述:
每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。


输出描述:
输出一行表示最大的乘积。
示例1
输入
3
7 4 7
2 50
输出
49*/

public class Choir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i ++) {
            val[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(helper(val, n, k, d));
    }
    public static long helper(int[] val, int n, int k, int d){
        long maxdp[] = new long[n + 1];
        long mindp[] = new long[n + 1];
        Arrays.fill(maxdp, 1);
        Arrays.fill(mindp, 1);
        // 遍历待选取的第k~第1名学生
        for (int i = k - 1; i >= 0; i --) {
            // 第i名学生(1...i0...i1...n,i0<=j<=i1),j是第i名学生的下标，要求i的前面至少有i - 1个人
            // 则j>=i, 要求i的后面至少有k-i个人，则n-j>=k-i,j<=n-k+i
            for (int j = i; j <= n - k + i; j ++) {
                // 前一名学生(i+1)可以是当前学生下标往后延顺d个，m=[j+1, j+d]
                for (int m = j + 1; m <= j + d && m <=n; m ++) {
                    long temp1 = val[j] * maxdp[m];
                    long temp2 = val[j] * mindp[m];
                    maxdp[j] = Math.max(maxdp[j], Math.max(temp1, temp2));
                    mindp[j] = Math.min(mindp[j], Math.min(temp1, temp2));
                }
            }
        }
        long res = Long.MIN_VALUE;
        for (long x: maxdp) {
            res = Math.max(x, res);
        }
        return res;
    }
}
