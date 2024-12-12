package LinkedList;


import java.util.HashSet;

/*
    判断链表中是否有环
    方法一：利用hash
    方法二：快慢双指针，fast指针一次走两步。slow指针一阵走一步，
           若快指针遇到null，则无环，如相遇则有环
 */
public class LinkedListHashCircle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //方法一
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head!=null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head=head.next;
        }
        return false;
    }


    //方法二
    public boolean hasCycle1(ListNode head) {
        if (head==null||head.next==null)
            return false;
        ListNode fast=head,slow=head;
        while (fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head!=null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head=head.next;
        }
        return null;
    }
}
