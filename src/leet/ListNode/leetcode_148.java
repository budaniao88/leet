package leet.ListNode;
/*
148. 排序链表
中等
相关标签
相关企业
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

示例 1：

输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：

输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]

提示：

链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105

进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
* */
public class leetcode_148 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  // 复制后采用二分法
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode fast = head.next, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode tmp = slow.next;
    slow.next = null;
    ListNode l = sortList(head);
    ListNode r = sortList(tmp);
    // 虚拟头节点
    ListNode h = new ListNode(0);
    ListNode res = h;
    //merge操作
    while (l!= null && r != null){
      if (l.val < r.val){
        h.next = l;
        l =  l.next;
      }else {
        h.next = r;
        r =  r.next;
      }
      h = h.next;
    }
    // 最后剩下的加到末尾
    h.next = (l != null) ? l : r ;

    return res.next;
  }
}
