import java.util.ArrayList;
import java.util.List;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/17 22:24
 */

/*
* 118. 杨辉三角


给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++){
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    array.add(1);
                }else {
                    array.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }

            }
            ans.add(array);
        }
        return ans;
    }
}
