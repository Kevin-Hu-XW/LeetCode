package LinkedList;

public class oddEvenList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
            return null;
        if (head.next.next==null)
            return head;
        ListNode p1 = head,p2 = head.next,head1 = p2;
        while (p1.next.next!=null){
            p1.next = p2.next;
            p1 = p1.next;
            if (p1.next!=null){
                p2.next = p1.next;
                p2 = p2.next;
            }else{
                break;
            }
        }
        p1.next = head1;
        p2.next = null;
        return head;
    }
}
