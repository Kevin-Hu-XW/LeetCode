package LinkedList;
/*
    先反转链表，再打印
 */
public class PrintListFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int[] reversePrint(ListNode head) {
        if (head==null)
            return new int[0];
        int len=0;
        ListNode p = head;
        while (p!=null){
            len++;
            p = p.next;
        }
        int [] a=new int[len];
        p=reverse(head);
        for (int i = 0;i<len;i++) {
            a[i] = p.val;
            p = p.next;
        }
        return a;
    }
    public ListNode reverse(ListNode head) {
        if (head==null)
            return null;
        ListNode pre=null;
        ListNode cur=head;
        ListNode temp;
        while (cur!=null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
