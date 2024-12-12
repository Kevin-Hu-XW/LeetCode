package LinkedList;

/*
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
    思路：题目要求时间空间复杂度分别为O(nlogn)和O(1)，联想到使用归并排序
    链表归并排序：
    1、分割：使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点
    2、合并
    重点：掌握查找链表中点代码
 */
public class sortList_ {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        //空链表或者只有一个节点（不需要排序），则返回head
        if (head==null||head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        //查找链表的中点
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //记录中点位置
        ListNode tmp = slow.next;
        slow.next = null;
        //递归分别对分割后的两条链表进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        //在对排序好的两条链表进行合并
        ListNode h = new ListNode(0);
        ListNode temp = h;
        while (left!=null&&right!=null){
            if (left.val<=right.val){
                temp.next = left;
                left = left.next;
            }
            else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left!=null?left:right;
        return h.next;
    }
}
