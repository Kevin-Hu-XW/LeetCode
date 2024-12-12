package LinkedList;

public class deleteDuplicates {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates1(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null){
            return head;
        }
        ListNode pre,cur,temp;
        pre=cur=head;
        while (cur!=null) {
            cur=cur.next;
            while (pre.val==cur.val&&cur!=null) {
                pre.next=cur.next;
                cur=cur.next;
            }
            pre=pre.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;
        ListNode cur=head;
        while (cur.next!=null) {
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
