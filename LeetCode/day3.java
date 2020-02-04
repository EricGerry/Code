package com.day3;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] num=new int[26]; //定义一个int型数组，来统计每个字符出现的次数
        for(int i=0;i<magazine.length();i++){
            num[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(num[ransomNote.charAt(i)-'a']==0){ //如果该字母出现次数为0，则返回false
                return false;
            }
            num[ransomNote.charAt(i)-'a']--; //否则将该字母可用次数减一
        }
        return true;
    }
    /*
    * 判断一个整数是否是回文数。
    * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数*/
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        //help记录位数，方便取得首位
        int help = 1;
        int tmp = x;
        while (tmp >= 10){
            help *= 10;
            tmp /= 10;
        }
        while (x != 0){
            if(x % 10 != x / help){
                return false;
            }
            //去除首、尾
            x = x % help / 10;
            help /= 100;
        }
        return  true;
    }
}
