package leet.ListNode;
/*
206. 反转链表
已解答
简单
相关标签
相关企业
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


示例 1：


输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：


输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]
提示：

链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000

进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
* */
public class leetcode_206 {
    public ListNode reverseList(ListNode head) {
        // 递归法
        return reverse(head,null);
        }
    // 有三个链表节点
    private ListNode reverse(ListNode head, ListNode pre) {
        if (head == null) return pre;
            ListNode temp = head.next;
            head.next = pre;
            return reverse(temp,head);
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
