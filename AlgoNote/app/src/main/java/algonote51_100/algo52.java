package algonote51_100;

public class algo52 {

    /***
     *  删除 倒数第 n 个节点 。
     *  我们需要 获取 的 是 第 n 个节点的前一个节点 。
     *  如果 采用 快慢节点的方法 。
     *  fast 指向 head
     *  slowPre 指向pre 。
     *  fast 需要先移动 n 步
     *  刚刚合适。
     *  以  只有 一个 节点  1 为例 。    n 也为1
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        ListNode fast = head;
        pre.next = head;
        ListNode slowPre = pre;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slowPre = slowPre.next;
        }
        slowPre.next = slowPre.next.next;
        return pre.next;
    }



    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
