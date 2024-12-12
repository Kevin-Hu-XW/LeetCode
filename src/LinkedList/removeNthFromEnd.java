package LinkedList;
/*
    让面试管因为你思考问题的方式而喜欢你
    方法一：利用栈，先入栈，后出栈，出栈第n个时弹出，注意特殊情况的判断
 */
import java.util.Stack;
public class removeNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removenodeFromEnd(ListNode head, int n) {
        if (head==null)
            return null;
        int len=0;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        ListNode temp1 = head;
        while (head!=null) {
            len++;
            stack.push(head);
            head = head.next;
        }
        if (n<=len){
            if (len==1&&n==1) {
                return null;
            }
            else if (len==n) {
                ListNode pos = temp1.next;
                temp1.next = null;
                return pos;
            }
            else {
                int m=0;
                ListNode node = null;
                ListNode pre;
                while (!stack.empty()&&m<n) {
                    node = stack.pop();
                    m++;
                }
                pre = stack.pop();
                pre.next = node.next;
                node.next = null;
                return temp;

            }

        }
        return null;
    }

    //方法二：栈弹出第N个节点为要删除的元素

}
