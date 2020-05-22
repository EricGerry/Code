import java.util.HashMap;
import java.util.Map;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/22 22:27
 */

/*
* 169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2*/

public class MostElements {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
         if (map.containsKey(nums[i])){
             map.put(nums[i], map.get(nums[i]) + 1);
         } else {
             map.put(nums[i], 1);
         }
        }
        int len = nums.length / 2;
        for (Map.Entry m : map.entrySet()){
            if ((int)m.getValue() > len){
                return (int)m.getKey();
            }
        }
        return -1;
    }
}
