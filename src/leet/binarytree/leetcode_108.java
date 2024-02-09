package leet.binarytree;

import java.security.Key;

/*
108. 将有序数组转换为二叉搜索树

相关标签
相关企业
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
示例 1：

输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

示例 2：

输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。

提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 按 严格递增 顺序排列
* */
public class leetcode_108 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // 先判断是否为空防止npe
        if (nums==null || nums.length == 0) return null;
        return sort(nums,0,nums.length);
    }

    private TreeNode sort(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right)>>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sort(nums,left,mid);
        root.right = sort(nums,mid+1,right);
        return root;
    }
}
