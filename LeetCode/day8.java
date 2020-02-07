package com.day8;

public class Solution {
    /*
    * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    * 你可以假设除了整数 0 之外，这个整数不会以零开头。
    *(1) 除 9之外的数字加一；
    *(2)数字 9。
    * 加一得十进一位个位数为 00 加法运算如不出现进位就运算结束了且进位只会是一。
    * 所以只需要判断有没有进位并模拟出它的进位方式，如十位数加 11 个位数置为 00，如此循环直到判断没有再进位就退出循环返回结果。
    * 然后还有一些特殊情况就是当出现 9999、999999 之类的数字时，循环到最后也需要进位，出现这种情况时需要手动将它进一位。
。*/
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    /*
    * 给定一个非空数组，返回此数组中第三大的数。
    * 如果不存在，则返回数组中最大的数。
    * 要求算法时间复杂度必须是O(n)。*/
    public int thirdMax(int[] nums) {
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int secondMax = Integer.MIN_VALUE;
        boolean a = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= secondMax && nums[i] < max) {
                secondMax = nums[i];
                a = true;
            }
        }
        if (!a) {
            return max;
        }
        int thirdMax = Integer.MIN_VALUE;
        boolean b = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
                b = true;
            }
        }
        if (!b) {
            return max;
        }
        return thirdMax;
    }

}
