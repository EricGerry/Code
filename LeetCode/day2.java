package com.day2;

public class Solution {
    public int removeElement(int[] nums, int val) {
        //移除元素法
        /*
        * 给定一个数组nums，以及一个val
        * 减去数组中等于val的值，
        * 最后返回nums数组的长度*/
        int i = 0;
        int n = nums.length;
        while (i < n){
            if (nums[i] == val){
                nums[i] = nums[n - 1];
                n--;
            }else {
                i++;
            }
        }
        return n;
    }
    public int removeElement_1(int[] nums, int val){
        //双指针法
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    /*
    * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。*/
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
