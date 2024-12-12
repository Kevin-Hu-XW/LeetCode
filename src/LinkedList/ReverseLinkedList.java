package LinkedList;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
            if (head==null)
                return null;
            ListNode temp;
            ListNode pre=null;
            ListNode cur=head;
            while (cur!=null) {
                temp=cur.next; //保存下一个节点，因为接下来要改变 cur->next 的指向了，将cur->next 指向pre
                cur.next=pre;  //将节点反转
                //两个节点分别向后移动一位
                pre=cur;
                cur=temp;
            }
            head=pre;

            return head;
    }
}
