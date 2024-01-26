package leet.ListNode;
/*
*234. 回文链表
简单
相关标签
相关企业
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

示例 1：

输入：head = [1,2,2,1]
输出：true
示例 2：

输入：head = [1,2]
输出：false


提示：

链表中节点数目在范围[1, 105] 内
0 <= Node.val <= 9
*
* */
public class leetcode_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // 1、找到前半部分的链表尾结点(快慢指针)
        ListNode firstHalfEnd = endOfFirstHalf(head);
        // 2、翻转后半部分链表
        ListNode secondHalfStart = reverseList(firstHalfEnd.next,null);
        // 3、判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean res = true;
        while(res && p2!=null){
            if (p1.val != p2.val){
                res = false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        // 4、恢复链表
        firstHalfEnd.next =reverseList(secondHalfStart,null);
        // 5、返回结果
        return res;
    }

    private ListNode reverseList(ListNode cur,ListNode pre ) {
        if (cur == null ) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverseList(temp,cur);
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

