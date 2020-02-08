package com.day9;

public class Solution {
    /*
    *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
    *你可以假设每种输入只会对应一个答案。
    * 但是，你不能重复利用这个数组中同样的元素。*/
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                   return new int[]{i, j};
                }

            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /*
    *给定两个二进制字符串，返回他们的和（用二进制表示）。
    *输入为非空字符串且只包含数字 1 和 0。*/
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        if(len1 < len2) return addBinary(b, a); //这里处理的比较巧妙，值得记住
        int[] result = new int[len1+1];

        int index = len1 - 1;
        int j = len2 - 1;
        while(index >= 0) {
            int tmp = j >= 0 ? (a.charAt(index) - '0') + (b.charAt(j) - '0') + result[index+1] : (a.charAt(index) - '0') + result[index+1];
            result[index+1] = tmp%2;
            result[index] += tmp/2;
            index--;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++) {
            if(i == 0 && result[i] == 0) continue;
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
