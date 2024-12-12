package LinkedList;

/*
    思路： 1.维护两个链表small和large即可,small链表放小于X的节点，large放大于X的节点，
          2.遍历完后，只需将small的next指针指向large即可
    注意：为了避免头结点为空的情况，需要设smallHead和largeHead分别为两个链表的哑节点
 */

public class SplitList_ {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        if (head==null)
            return null;
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        ListNode cur = head;
        while (cur!=null) {
            //小于x的节点放入small链表中
            if (cur.val<x) {
                small.next = cur;
                small = small.next;
            }
            else //大于X的链表放入large链表中
                {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        //把连个链表链接起来，并把large节点的next指针设为null
        small.next=largeHead.next;
        largeHead.next=null;
        large.next=null;
        return smallHead.next;

    }
}
