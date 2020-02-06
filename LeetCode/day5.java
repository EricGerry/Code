package com.day5;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /*
    * 给定一个整数数组，判断是否存在重复元素。
    * 如果任何值在数组中出现至少两次，函数返回 true。
    * 如果数组中每个元素都不相同，则返回 false。*/
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsDuplicate_2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate_3(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
    /*
    * 对于字符串 S = 'aabbbbccc'，可以把表示成这种分组形式 - groupify(S) = [('a', 2), ('b', 4), ('c', 3)]，
    * 其中 'abc' 为 键值，[2, 4, 3] 为 连续出现的次数。对于一个长按键入的 typed 来说，依次每个字母连续出现的次数
    * 一定大于等于 name 中连续字母出现的次数。
    * 举个例子，'aaleex' 是 'alex' 其中一种长按键入的名字： 首先把它们分别变成
    *  [('a', 2), ('l', 1), ('e', 2), ('x', 1)] 和 [('a', 1), ('l', 1), ('e', 1), ('x', 1)] 的形式
    * 这两个字符串的键值都是 'alex'，同时 [2,1,2,1] 也分别大于 [1,1,1,1]（(2 >= 1, 1 >= 1, 2 >= 1, 1 >= 1)）。
    * */
    public boolean isLongPressedName(String name, String typed) {
        Group g1 = groupify(name);
        Group g2 = groupify(typed);
        if (!g1.key.equals(g2.key))
            return false;

        for (int i = 0; i < g1.count.size(); ++i)
            if (g1.count.get(i) > g2.count.get(i))
                return false;
        return true;
    }

    public Group groupify(String S) {
        StringBuilder key = new StringBuilder();
        List<Integer> count = new ArrayList();
        int anchor = 0;
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || S.charAt(i) != S.charAt(i+1)) { // end of group
                key.append(S.charAt(i));
                count.add(i - anchor + 1);
                anchor = i+1;
            }
        }

        return new Group(key.toString(), count);
    }
}

class Group {
    String key;
    List<Integer> count;
    Group(String k, List<Integer> c) {
        key = k;
        count = c;
    }
    /*双指针法
    * 同方法一类似的思路，检查每个字母和连续出现的次数，但用了更优雅地方式来实现。
    * 有以下几种情况可以跳过检查 typed 中的一些字母。在下面的例子中，用（name, typed）这种形式来表示：
    * 在 ('aab', 'aaaaab') 这种情况下，可以跳过检查 typed 中的 3 - 5 位置上的 a，因为处理到第二个 a 的时候就已经满足了。
    * 在 ('a', 'b') 这种情况下， 检查到 typed 中 'b' 的时候可以直接返回 False。
    * 算法
    * 根据上面的思路可以得出以下算法：
    * 对于 name 中的每个字母，如果跟 typed 中的对不上了
    * 如果这是 type 每一块中的第一个字母，直接返回 False。
    * 如果不是，把 typed 指针右移到下一个不同的字母处或者结尾。如果下一个字母跟对应 name 的字母还不相同，直接返回 False。
    * */
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;

            // If mismatch...
            if (typed.charAt(j) != c) {
                // If it's the first char of the block, ans is false.
                if (j==0 || typed.charAt(j-1) != typed.charAt(j))
                    return false;

                // Discard all similar chars
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;

                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }

            j++;
        }

        return true;
    }
}
