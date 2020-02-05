package com.day4;

public class Solution {
    /*
    * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，
    * 返回其最后一个单词的长度。*/
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
    /*
    * 给定两个有序整数数组 nums1 和 nums2，
    * 将 nums2 合并到 nums1 中，
    * 使得 num1 成为一个有序数组。*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        int s1 = m - 1;
        int s2 = n - 1;
        while (s1 >= 0 && s2 >= 0) {
            if (nums1[s1] >= nums2[s2]) {
                nums1[pos--] = nums1[s1--];
            } else {
                nums1[pos--] = nums2[s2--];
            }
        }
        while (s1 >= 0) {
            nums1[pos--] = nums1[s1--];
        }
        while (s2 >= 0) {
            nums1[pos--] = nums2[s2--];
        }
    }
}
