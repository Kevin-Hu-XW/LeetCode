package LinkedList;
/*
    创建哑铃节点可以避免讨论头结点的情况
 */
public class SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead,cur = head;
        while (cur!=null&&cur.next!=null) {
            pre.next = cur.next;
            pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = cur.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        ListNode head = swapPairs(node);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
