package com.day1;

public class Solution {
    public String toLowerCase(String str) {
        //字符串中大写字母转化为小写字母输出
        char[] Values = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                Values[i] = (char) (str.charAt(i) + 32);
            } else {
                Values[i] = (char) (str.charAt(i));
            }
        }
        return String.valueOf(Values);
    }
/*
* 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
* 输入: [1,2,3,4,5,6,7] 和 k = 3
* 输出: [5,6,7,1,2,3,4]
* */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        swap(nums, 0, nums.length - k - 1);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);

    }

    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
