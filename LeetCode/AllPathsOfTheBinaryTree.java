import java.util.ArrayList;
import java.util.List;

/**
 * @version 2020.1
 * @Author Eric
 * @date 2020/6/1 22:18
 */

/*
* 257. 二叉树的所有路径

给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3*/

public class AllPathsOfTheBinaryTree {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        String string = new String("");
        cal(root, string, result);
        return result;
    }

    private void cal(TreeNode node, String curLevel, List<String> result){
        if(node != null){
            curLevel += node.val;
            if(node.left == null && node.right == null){
                result.add(curLevel);
            }else{
                curLevel += "->";
                cal(node.left, curLevel, result);
                cal(node.right, curLevel, result);
            }
        }
    }
}
