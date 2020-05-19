/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/19 22:15
 */

/*
* 125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
* */

public class VerifyPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end){
            while (start < end && !isLetterOrDigit(s.charAt(start))){
                start ++;
            }
            while (start < end && !isLetterOrDigit(s.charAt(end))){
                end --;
            }
            if (!toLowerCase(s.charAt(start)).equals(toLowerCase(s.charAt(end)))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean isLetterOrDigit(Character c){
        if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')){
            return true;
        }
        return false;
    }
    public Character toLowerCase(Character c){
        if ('A' <= c && c <= 'Z'){
            return (char)(c + 32);
        }
        return c;
    }
}
