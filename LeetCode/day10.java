package com.day10;

public class Solution {
    /*
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
*/
    public int myAtoi(String str) {
        //re返回值；negative负数；positive正数；isCal是否进行计算
        int re = 0,negative = 0,positive = 0,isCal = 0;
        //将字符串转换成字符数组用for-each进行遍历
        for(char t : str.toCharArray()){
            /*
             *排除前方的空格同时判断是否以除数字或者正负号以外的开头
             *如果是直接返回0
             */
            if(isCal == 0){
                if((t <= '9' && t >= '0') || t == ' ' || t == '-' || t == '+'){
                    ;
                }else{
                    return 0;
                }
            }
            //如果当前为0-9和正负号可计算，否则判断是否存在负号并进行return
            if((t <= '9' && t >= '0') || t == ' ' || t == '-' || t == '+'){
                if(t == '-'){
                    //如果前方存在正号即为"+-"则不合法返回0
                    if(positive == 1 ){
                        return 0;
                    }
                    //如果此负号前进行过计算则判断之前是否存在负号并进行return
                    if(isCal ==1){
                        if(negative == 1){
                            re = -re;
                        }
                        return re;
                    }
                    //如果是第一次遇到负号，将negative置1，同时把isCal置1代表计算过
                    negative=1;
                    isCal=1;
                }else if(t == '+'){
                    //同负号
                    if(negative == 1 ){
                        if(re !=0){
                            re = -re;
                            return re;
                        }else {
                            return 0;
                        }
                    }
                    if(isCal ==1){
                        if(negative == 1){
                            re = -re;
                        }
                        return re;
                    }
                    positive=1;
                    isCal=1;
                }else if (t == ' '){
                    //如果前方计算过又遇到空格则检查是否有负号并return
                    if(isCal != 0){
                        if(negative == 1){
                            re = -re;
                        }
                        return re;
                    }else if(isCal == 1){
                        return 0;
                    }
                }else {
                    if (negative == 1) {
                        int bbq = -re;
                        if (bbq < Integer.MIN_VALUE / 10 || (bbq == Integer.MIN_VALUE / 10 && t - 48 > 8)) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        if (re > Integer.MAX_VALUE / 10 || (re == Integer.MAX_VALUE / 10 && t - 48 > 7)) {
                            return Integer.MAX_VALUE;
                        }
                    }
                    re = re * 10 + t - 48;
                    isCal = 1;
                }
            }else if (isCal != 0){
                if(negative == 1){
                    re = -re;
                }
                return re;
            }
        }
        if(negative == 1){
            re = -re;
        }
        return re;
    }
    /*
    * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    * 你的算法时间复杂度必须是 O(log n) 级别。
    * 如果数组中不存在目标值，返回 [-1, -1]。
*/
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        search(nums, 0, nums.length-1, target, result);
        return result;
    }

    private void search(int[] nums, int low, int high, int target, int[] result) {
        if (low>high) return;
        int mid = (low+high)/2;
        if (nums[mid] == target) {
            if (result[0] == -1 || mid <= result[0]) {
                result[0] = mid;
            }
            if (mid >= result[1]) {
                result[1] = mid;
            }
            search(nums, low, mid-1, target, result);
            search(nums, mid+1, high, target, result);
        } else if (nums[mid] > target) {
            search(nums, low, mid-1, target, result);
        } else {
            search(nums, mid+1, high, target, result);
        }
    }
}
