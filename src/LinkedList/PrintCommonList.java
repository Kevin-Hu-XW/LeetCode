package LinkedList;
/*
    给定两个有序链表的头指针head1和head2，打印两个
    链表的公共部分，指的是内容，判定相交指的是内存地址
    思路：通过使用双指针进行遍历
 */
public class PrintCommonList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void  CommonList(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) {
            throw new RuntimeException("the listnode is null!");
        }
        
        while (headA!=null&&headB!=null) {
            if (headA.val<headB.val) {
                headA=headA.next;
            }else if (headA.val>headB.val) {
                headB=headB.next;
            }else{

                System.out.println(headA.val);
                headA=headA.next;
                headB=headB.next;
            }
        }
    }
    public static void printLinkedList(ListNode node) {
        if (node==null) {
            throw new RuntimeException("the node is null");
        }
        while (node!=null) {
            System.out.print(node.val+"->");
            node=node.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        ListNode node1=new ListNode(2);
        node1.next=new ListNode(3);
        node1.next.next=new ListNode(5);
        node1.next.next.next=new ListNode(6);
        printLinkedList(node1);
        System.out.println();
        ListNode node2=new ListNode(1);
        node2.next=new ListNode(2);
        node2.next.next=new ListNode(5);
        node2.next.next.next=new ListNode(7);
        node2.next.next.next.next=new ListNode(8);
        printLinkedList(node2);
        System.out.println();
        System.out.println("Common Part!");
        CommonList(node1,node2);



    }
}
