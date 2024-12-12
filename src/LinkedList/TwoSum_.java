package LinkedList;
import java.util.Stack;
/*
    创建链表，需要head和tail指针，head指针指向第一个节点，tail指向尾节点，
    插入操作在尾节点的next指向新的节点。
 */
public class TwoSum_ {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //暴力
    public static ListNode head=new ListNode();
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1!=null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        String str1 = "",str2 = "";
        while (!stack1.isEmpty())
            str1 = str1+String.valueOf(stack1.pop());
        while (!stack2.isEmpty())
            str2 = str2 +String.valueOf(stack2.pop());
        Integer sum=0;
        if (str1!=""&&str2!="")
            sum = Integer.parseInt(str1)+Integer.parseInt(str2);
        char [] chars = String.valueOf(sum).toCharArray();
        char[] chars1= new char[chars.length];
        int j=0;
        for (int i=chars.length-1;i>=0;i--){
            chars1[j++] = chars[i];
        }
        System.out.println();
        for (int i=0;i<chars1.length;i++) {
            insert(Integer.parseInt(String.valueOf(chars1[i])));
        }
        return head.next;
    }
    public static void insert(int data){
        ListNode node = new ListNode(data);
        ListNode temp = head;
        while (temp.next!=null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    //双指针
    /*
        由于连个链表是逆序，所以同一位置的值可以直接相加，具体而言，
        如果当前两个链表处相应位置的数字为 val1,val2，进位值为carry ，
        则它们的和为 val1+val2+carry；其中，
        答案链表处相应位置的数字为(val1+val2+carry)%10 而新的进位值为(val1+val2+carry)/10
        如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个0。
        此外，如果链表遍历结束后，如果有carry>0 ，还需要在答案链表的后面附加一个节点，节点的值为carry。

     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,tail=null;   //创建head，tail节点用于创建链表
        int carry = 0;
        while (l1!=null||l2!=null) {
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            int sum = val1+val2+carry;
            //构建两链表之和，新的链表节点
            if (head==null) {
                head=tail=new ListNode(sum%10);
            }
            else{
                tail.next = new ListNode(sum%10);
                //尾指针移动到下一位
                tail =tail.next;
            }
            if (l1!=null)
                l1 = l1.next;
            if (l2!=null)
                l2 = l2.next;
            carry = sum/10;
        }
        //若循环结束carry大于0，则向前进一位
        if(carry>0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);

        ListNode l2 = new ListNode(0);

        ListNode list1=l1;
        ListNode list2=l2;
        while (l1!=null){
            System.out.print(l1.val+" ");
            l1 = l1.next;
        }
        System.out.println();
        while (l2!=null){
            System.out.print(l2.val+" ");
            l2 = l2.next;
        }
        ListNode l3 = addTwoNumbers(list1,list2);
        System.out.println("结果");
        while (l3!=null){
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }
}
