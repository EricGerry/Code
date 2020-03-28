/**
 * @Author：Eric
 * @Date：2020/3/28 18:12
 */

import java.util.*;

/*
* 二叉树平衡检查
* 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。

给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。*/
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class Balance {
    boolean isPass = true;
    public boolean isBalance(TreeNode root) {
        getDepthOfTree(root);
        return isPass;
    }

    public int getDepthOfTree(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = getDepthOfTree(node.left);
        int right = getDepthOfTree(node.right);
        if(Math.abs(left-right)>1){
            isPass = false;
        }
        return left>right?left+1:right+1;
    }
}