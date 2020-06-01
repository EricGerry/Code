import java.util.HashMap;
import java.util.Map;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/6/1 22:37
 */

/*
* 242. 有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false*/

public class EffectiveEccentricWords {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0){
            return true;
        }
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++){
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }else {
                return false;
            }
        }
        for (Map.Entry m : map.entrySet()){
            if ((Integer) m.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
