/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/6/2 22:34
 */

/*
* 263. 丑数

编写一个程序判断给定的数是否为丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例 1:

输入: 6
输出: true
解释: 6 = 2 × 3
示例 2:

输入: 8
输出: true
解释: 8 = 2 × 2 × 2
示例 3:

输入: 14
输出: false
解释: 14 不是丑数，因为它包含了另外一个质因数 7。*/

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0){
            return false;
        }
        int[] Base = new int[]{2, 3, 5};
        for (int i : Base){
            while (num % i == 0){
                num = num / i;
            }
        }
        if (num == 1){
            return true;
        }
        return false;
    }
}
