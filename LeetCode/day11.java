package com.day11;

public class Solution {
    /*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。*/
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !isLetterOrDigit(s.charAt(start))) start++;
            while (start < end && !isLetterOrDigit(s.charAt(end))) end--;
            if (toLowerCase(s.charAt(start)) != toLowerCase(s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean isLetterOrDigit(Character c) {
        if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
            return true;
        }
        return false;
    }

    public Character toLowerCase(Character c) {
        if ('A' <= c && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
    }
    /*
    * 给定一组字符，使用原地算法将其压缩。
    * 压缩后的长度必须始终小于或等于原数组长度。
    * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
    * 在完成原地修改输入数组后，返回数组的新长度。
*/
    public int compress(char[] chars) {
        int t=0;//设置指针
        int i=0;
        while (i <chars.length && t<chars.length) {//遍历字符串
            chars[t++]=chars[i];//取相同字符序列的首字符存下
            int temp=i;//记录相同字符序列首元素位置
            while (i<chars.length &&chars[i]==chars[t-1])
                i++;//i指针滑动到相同字符序列末尾的下一个位置
            if(i-temp>1){//若相同字符序列长度大于1
                for(char c:String.valueOf(i-temp).toCharArray()){//向结果中加入相同字符序列的长度的字符形式
                    chars[t++]=c;
                }
            }
        }
        return t;//t即为已压缩的结果的长度
    }
}
