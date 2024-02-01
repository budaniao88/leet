package leet.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/*
* 104. 二叉树的最大深度
已解答
简单
相关标签
相关企业
给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

示例 1：

输入：root = [3,9,20,null,null,15,7]
输出：3
示例 2：

输入：root = [1,null,2]
输出：2

提示：

树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100
* */
public class leetcode_104 {
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
    public int maxDepth(TreeNode root) {
       // 利用层序遍历：用队列模拟层序遍历 用双向链表实现队列
       // 1、 创建两个链表 一个装每一层元素 一个用来循环子节点
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}} , tmp ;
        int res = 0;
        while (!queue.isEmpty()){
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if(node.left != null){
                    tmp.add(node.left);
                }
                if (node.right != null){
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            res ++;
        }
       return res;
    }
}
