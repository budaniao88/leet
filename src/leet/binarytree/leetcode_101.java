package leet.binarytree;
/*
*101. 对称二叉树
简单
相关标签
相关企业
给你一个二叉树的根节点 root ， 检查它是否轴对称。

示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false

提示：

树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100

进阶：你可以运用递归和迭代两种方法解决这个问题吗？
* */
public class leetcode_101 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    public boolean  isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        // 此时不可能都为空
        if (left == null || right == null) return  false;
        if (left.val != right.val) return  false;
        return (dfs(left.left,right.right) && dfs(left.right,right.left));
    }
}
