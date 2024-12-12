package LinkedList;
/*
    方法一：利用栈结构
    方法二：双指针整个流程可以分为以下五个步骤：
           1.找到前半部分链表的尾节点。
           2.反转后半部分链表。
           3.判断是否回文。
           4.恢复链表。
           5.返回结果。
 */
import java.util.Stack;

public class IsPalindromeList_ {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //方法一
    public boolean isPalindrome1(ListNode head) {
        ListNode temp=head;
        Stack<Integer> stack=new Stack<Integer>();
        while (temp!=null) {
            stack.add(temp.val);
            temp=temp.next;
        }
        while (head!=null) {
             if (head.val!=stack.pop())
                 return false;
             head=head.next;
        }
        return true;
    }









    //方法二：双指针，不适用额外空间
    public boolean isPalindrome2(ListNode head) {
        if (head==null&&head.next==null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode endoFFirstHalf = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(endoFFirstHalf.next);

        //判断是否为回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean res=true;
        while (p1!=null&&p2!=null) {   //
            if (p1.val!=p2.val){
                res = false;
                break;
            }
            p1=p1.next;
            p2=p2.next;
        }

        //还原链表并返回结果
        endoFFirstHalf.next = reverseList(secondHalfStart);
        return res;
    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode temp;
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null) {
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
    //获得链表的中点位置
    public ListNode endOfFirstHalf(ListNode head) {
        ListNode fast=head,slow=head;
        //验证fast.next、fast.next.next是否存在，不存在就结束
        while (fast.next!=null&&fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }







    public static void main(String[] args) {

    }
}
