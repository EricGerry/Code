import java.util.ArrayList;
import java.util.List;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/5/18 23:13
 */

/*
* 119. 杨辉三角 II

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]*/

public class YangHuiTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; i++){
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    array.add(1);
                }else {
                    array.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }

            }
            ans.add(array);
            if (i == rowIndex){
                return array;
            }
        }
        return null;
    }
}
