package leet.binarytree;
/*
*226. 翻转二叉树
简单
相关标签
相关企业
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
示例 2：

输入：root = [2,1,3]
输出：[2,3,1]
示例 3：

输入：root = []
输出：[]

提示：

树中节点数目范围在 [0, 100] 内
-100 <= Node.val <= 100
*
* */


import java.util.Stack;

public class leetcode_226 {
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
    public TreeNode invertTree(TreeNode root) {
        // 递归
        /*if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }*/
        // 迭代
        if (root == null){
            return  null;
        }
        Stack<TreeNode> stk = new Stack<>(){{add(root);}};
        while (!stk.isEmpty()){
            TreeNode node = stk.pop();
            if (node.left != null)stk.add(node.left);
            if (node.right !=null)stk.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
            return root;
    }
}
