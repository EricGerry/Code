/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/6/9 23:10
 */

/*
* 367. 有效的完全平方数


给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False*/

public class EffectivePerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
