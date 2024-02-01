package leet.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leectode_102 {
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

   // 出现并发修改异常（ConcurrentModificationException）
   // 是因为你在遍历队列的同时试图修改它（在 for-each 循环中添加元素）。
   // Java 的 for-each 循环基于迭代器实现，不允许在遍历过程中修改集合，
   // 否则会抛出这个异常。

   //为了解决这个问题，你可以在遍历队列之前先记录下当前层的节点数量，
   // 然后只遍历这么多的节点，这样就不会在遍历过程中修改队列了。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<TreeNode>(),tmp;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> t = new ArrayList<>();
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                t.add(node.val);
                if (node.left != null)
                    tmp.offer(node.left);
                if (node.right != null)
                    tmp.offer(node.right);
            }
            res.add(t);
            queue = tmp;
        }
        return res;
    }
}
