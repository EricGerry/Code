import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @Author：Eric
 * @Date：2020/4/25 16:40
 */

/*单调栈结构
热度指数：840时间限制：C/C++ 4秒，其他语言8秒空间限制：C/C++ 256M，其他语言512M
算法知识视频讲解
给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。


输入描述:
第一行输入一个数字 n，表示数组 arr 的长度。

以下一行输出 n个数字，表示数组的值。


输出描述:
输出n行，每行两个数字 L 和 R，如果不存在，则值为-1，下标从0开始。
示例1
输入
7
3 4 1 5 6 2 7
输出
-1 2
0 2
-1 -1
2 5
3 5
2 -1
5 -1

备注:
1 \le n \le 10000001≤n≤1000000
-1000000 \le arr_i \le 1000000−1000000≤arr
i≤1000000*/

public class MonotoneStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[][] result = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int top = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                result[top][0] = leftIndex;
                result[top][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int top = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            result[top][0] = leftIndex;
            result[top][1] = -1;
        }
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

}
