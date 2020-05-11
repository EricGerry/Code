/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/11 22:20
 */

/*
* 69. x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。*/

public class SquareRootOfX{
    public int mySqrt(int x) {
        int ans = -1, n = x, i = 0;
        while (i <= n){
            int mid = i + (n - i) / 2;
            if ((long)mid * mid <= x){
                ans = mid;
                i = mid + 1;
            }else {
                n = mid - 1;
            }
        }
        return ans;
    }
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
