package LinkedList;

public class RemoveElements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return null;
        //创建dummyHead，排除头结点的影响
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead,cur = head;
        while (cur!=null){
            if (cur.val==val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
