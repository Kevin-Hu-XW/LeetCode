package LinkedList;

public class Test {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val,ListNode next){this.val = val;this.next = next;}
    }
    public ListNode ReverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        if (cur==null) return null;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            //两个节点向后移动一位
            pre = cur;
            cur = temp;
        }
        head= pre;
        return pre;
    }
}
