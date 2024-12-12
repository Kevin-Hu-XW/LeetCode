package LinkedList;

import java.util.Stack;
/*
    链表反转+链表合并
 */
public class reorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        int count = 0;
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
            count++;
        }
        if (count==1||count==2)
            return ;
        temp = head;
        ListNode p1 = temp,p2 = temp.next,node;
        int len = count/2;
        while (len>0){
            node = stack.pop();
            p1.next = node;
            node.next = p2;
            p1 = p2;
            p2 = p2.next;
            len--;
        }
        if (count%2==0){
            p2.next = null;
        }else{
            p1.next = null;
        }
        head = temp;
    }
}
