package LinkedList;
/*
    合并两排序链表
 */
public class MergeTwoSortedLinkedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l0 =head;
        if (l1==null&&l2==null)
            return null;
        else if (l1==null&&l2!=null) {
            return l2;
        }
        else if (l1!=null&&l2==null) {
            return l1;
        }
        else{
            while (l1!=null&&l2!=null) {
                if(l1.val<l2.val) {
                    head.next=l1;
                    l1=l1.next;
                    head = head.next;
                }else if (l1.val>=l2.val){
                    head.next = l2;
                    l2 = l2.next;
                    head = head.next;
                }
            }
            if (l1!=null) {
                head.next = l1;
            }
            if (l2!=null) {
                head.next = l2;
            }
        }
        return l0.next;
    }
}
