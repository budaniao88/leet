package leet.ListNode;
/*
24. 两两交换链表中的节点
已解答
中等
相关标签
相关企业
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]

提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
* */

public class leetcode_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public ListNode swapPairs(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode tmp  =  dummyHead;
            while (tmp.next != null && tmp.next.next != null){
                ListNode n1 = tmp.next;
                ListNode n2 = tmp.next.next;
                tmp.next = n2;
                n1.next = n2.next;
                n2.next = n1;
                tmp = n1;
            }
            return dummyHead.next;
        }
    }
}
