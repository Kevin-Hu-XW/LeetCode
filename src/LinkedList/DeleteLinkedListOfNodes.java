package LinkedList;

public class DeleteLinkedListOfNodes {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre;   //当前节点的前一个节点
        ListNode cur = head;
        //当要删除的节点为头结点时
        if (cur.val==val&&cur==head) {
            pre=new ListNode(0);
            pre.next=cur.next;
            cur.next=null;
            return pre.next;
        }
        //当要删除的节点不是头结点
        pre = head;
        cur = head.next;
        while (cur!=null) {
           if (cur.val==val) {
               pre.next=cur.next;
               cur.next=null;
           }
           pre = pre.next;
           cur = cur.next;
        }
        return head;
    }
}
