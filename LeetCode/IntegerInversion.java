/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/4 22:23
 */

/*
* 7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。*/

public class IntegerInversion {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int tmp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x = x / 10;
        }
        return res;
    }
}
