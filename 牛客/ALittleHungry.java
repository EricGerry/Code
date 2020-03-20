/**
 * @Author：Eric
 * @Date：2020/3/20 20:31
 */
/*
* 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。
* 最开始小易在一个初始位置x_0。
* 对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。
* 因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
* 贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。
* 小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
* 输入描述:
* 输入一个初始位置x_0,范围在1到1,000,000,006
* 输出描述:
* 输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
* 示例1
* 输入
* 125000000
* 输出
* 1
* */
import java.util.Scanner;
public class ALittleHungry {
    public static void main(String[] args) { Scanner scanner = new Scanner(System.in);
        long x0 = scanner.nextLong();
        long m = 1000000007;//取模的值
        long s = 100000;// 神秘力量使用的次数
        long[] begin = new long[3]; //f(x) = 4x+3 执行3次
        // 3次的取值
        begin[0] = x0;
        begin[1] = (4 * begin[0] + 3) % m;
        begin[2] = (4 * begin[1] + 3) % m;
        long minStep = s;
        long cur = 0;
        int step = 0;//执行的步数
        for (int i = 0; i < 3; i++) {
            cur = begin[i];
            step = i;
            while (cur != 0 && step < minStep) {
                cur = (8 * cur + 7) % m;//g(x) = 8x+7 执行
                step++;
            }
            minStep = minStep < step ? minStep : step;
        }
        if (minStep < s) {
            //如果执行步长没有超过s输出最小步长
            System.out.println(minStep);
        } else {
            //超过返回-1
            System.out.println(-1);
        }
    }
}
