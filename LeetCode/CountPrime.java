/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/27 23:12
 */

/*
* 204. 计数质数

统计所有小于非负整数 n 的质数的数量。

示例:

输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。*/

public class CountPrime {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++){
            arr[i] = 1;
        }
        for (int i = 2; i < n; i++){
            if (arr[i] == 1){
                for (int j = 2; i * j < n; j++){
                    arr[i * j] = 0;
                }
            }
        }
        for (int i = 2; i < arr.length; i++){
            if (arr[i] == 1){
                res++;
            }
        }
        return res;
    }
}
