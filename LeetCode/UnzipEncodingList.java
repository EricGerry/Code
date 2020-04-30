import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/4/30 21:24
 */

/*
*  解压缩编码列表

给你一个以行程长度编码压缩的整数列表 nums 。

考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。

请你返回解压后的列表。



示例：

输入：nums = [1,2,3,4]
输出：[2,4,4,4]
解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
示例 2：

输入：nums = [1,1,2,3]
输出：[1,3,3]


提示：

2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100*/

public class UnzipEncodingList {
    public int[] decompressRLElist(int[] nums) {
        int newLength = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            newLength = newLength + nums[i];
        }
        int[] newNums = new int[newLength];
        int Start = 0;
        int End = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            End=End+nums[i];
            for (int j = Start; j < End; j++) {
                newNums[j] = nums[i + 1];
            }

        }
        return newNums;
    }
}
