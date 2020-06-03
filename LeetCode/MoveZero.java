import java.util.ArrayList;
import java.util.List;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/6/3 21:32
 */

/*
* 283. 移动零

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]*/

public class MoveZero {
    public void moveZeroes(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                l1.add(nums[i]);
            }
        }
        int ZeNo = nums.length - l1.size();
        for (int i = 0; i < ZeNo; i++){
            l1.add(0);
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = l1.get(i);
        }
    }
}
