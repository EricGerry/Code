/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/6/1 22:06
 */

/*
* 258. 各位相加

给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

示例:

输入: 38
输出: 2
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。*/

public class AddEveryone {
    public int addDigits(int num) {
        while (num >= 10){
            num = num / 10 + num % 10;
        }
        return num;
    }
}
