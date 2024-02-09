package leet.binarytree;

import java.util.*;

/*
* 199. 二叉树的右视图
中等
相关标签
相关企业
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例 1:

输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
示例 2:

输入: [1,null,3]
输出: [1,3]
示例 3:

输入: []
输出: []

提示:

二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100
* */
public class leetcode_199 {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            int levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = nodeQueue.poll();
                if (i == levelSize -1 ){
                    view.add(cur.val);
                }
                if (cur.left != null){
                    nodeQueue.offer(cur.left);
                }
                if (cur.right != null){
                    nodeQueue.offer(cur.right);
                }
            }
        }
        return view;
    }
}
