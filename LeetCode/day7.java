package com.day7;

public class Solution {
    /*
    * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
    * 如果是 (0, 1)，那么万事大吉 i++ 并且 j--。
    * 如果是 (1, 0)，那么交换两个元素，然后继续。
    * 如果是 (0, 0)，那么说明 i 位置是正确的，只能 i++。
    * 如果是 (1, 1)，那么说明 j 位置是正确的，只能 j--
*/
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
    /*
    * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
    * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
    * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。*/
    public int pivotIndex(int[] nums) {
        int ans = -1;
        int leftsum = 0;
        int rightsum = 0;
        for (int i = 0; i < nums.length; i++) rightsum += nums[i];
        for (int i = 0; i < nums.length; i++) {
            rightsum -= nums[i];
            if (leftsum == rightsum) {
                ans = i;
                break;
            } else {
                leftsum += nums[i];
            };
        };
        return ans;
    }

}
