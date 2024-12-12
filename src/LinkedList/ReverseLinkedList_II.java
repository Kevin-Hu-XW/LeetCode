package LinkedList;
/*
    理清「穿针引线」的先后步骤，然后再编码
    思路：1、先将待返转的区域反转
         2、把pre->next指向反转后链表的头结点，把反转后链表的尾节点的next指向succ
    注意点：创建头结点，来避免分类讨论
 */
public class ReverseLinkedList_II {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null)
            return null;
        if (left==right)
            return head;
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre=dummyHead,cur=dummyHead,succ;
        //得到pre位置
        for (int i=0;i<left-1;i++) {
            pre = pre.next;
            System.out.println(pre.val);
        }
        //得到succ位置
        cur = pre;
        for (int j=left;j<=right;j++) {
            if (cur!=null)
               cur = cur.next;
        }
        succ = null;
        if (cur.next!=null)
            succ = cur.next;
        cur.next=null;
        ListNode head1 = reverselist(pre.next);
        cur = head1;
        while (cur.next!=null) {
            cur = cur.next;
        }
        //链接后一段链表
        cur.next = succ;
        //前面的链表与反转后的链表相连
        pre.next = head1;
        return dummyHead.next;
    }
    //反转链表
    public static ListNode reverselist(ListNode listNode) {
        if (listNode==null)
            return null;
        ListNode pre=null,cur=listNode,head=listNode;
        while (cur!=null) {
            head=head.next;
            cur.next = pre;
            pre = cur;
            cur= head;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        int left=2,right=4;
        ListNode node1=reverseBetween(node,left,right);
        while (node1!=null){
            System.out.print(node1.val+" ");
            node1 =node1.next;
        }
    }
}
