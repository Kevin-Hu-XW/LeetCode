package LinkedList;

public class rotateLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /*
        思路： 1.若旋转长度是链表长度的整数倍，则没必须要旋转
              2.旋转长度不是链表的整数倍，则旋转k%length次
              3.然后把倒数第k%length个开始的链表断开，并与头链表相链接
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||k<0)
            return null;
        int len=0;
        ListNode cur=head;
        ListNode head1,current,temp;
        while (cur!=null) {
            len++;
            cur=cur.next;
        }
        cur=head;
        if (k%len==0)
            return head;
        else {
            int rotate = k%len;
            int i=1;
            while (i<len-rotate) {
                cur = cur.next;
                i++;
            }
            head1 = cur.next;
            cur.next = null;
            //对断开后的链表进行反转
            current =head1;
            //合并链表
            cur = current;
            while (cur.next!=null) {
                cur = cur.next;
            }
            cur.next=head;
        }
        return current;
    }
    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(5);
        node.next.next.next=new ListNode(6);
        ListNode listNode =rotateRight(node,2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }




    }
}
