import java.util.Arrays;

/**
 * @Author：Eric
 * @Date：2020/3/25 19:05
 */
/*
* 春节期间小明使用微信收到很多个红包，非常开心。
* 在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。
* 请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
* 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
* 若没有金额超过总数的一半，返回0。
* 测试样例：
* [1,2,3,2,2],5
* 返回：2
* */
public class Gift {
    public int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int ans = gifts[n / 2];
        int num = 0;
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] == ans) {
                num++;
            }
        }
        return num <= n / 2 ? 0 : ans;
    }
}
