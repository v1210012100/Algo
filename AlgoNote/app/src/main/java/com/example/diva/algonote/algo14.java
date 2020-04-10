package com.example.diva.algonote;

// 234 题
/***
 * 1   2    3    1
 *  1 找到链表的中点（ 是否包括中间节点）： 如果是 奇数，则 中点为 正中间 节点
 *  2 对链表的后一半（ 包括中间节点进行翻转 ）。   1   3
 *  3 此时原生链表没有执行过断开操作，所以 原生链表为  1   2    3
 *  最后一个节点 3 。两个链表都指向它 。
 *  所以 比较 以 翻转的后半段列表为准 。
 */
public class algo14 {
    public static  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode middle = middle(head);
        ListNode reverse = reverse(middle);
        while(reverse!=null){
            if(head.val != reverse.val){
                return false;
            }
            head =head.next;
            reverse = reverse.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur !=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
