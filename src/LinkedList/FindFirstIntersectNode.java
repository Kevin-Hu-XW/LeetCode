package LinkedList;
/*
    单链表可能有环，也可能无环。给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能
    不相交。请实现一个函数， 如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null 即可。 要求：如果链表1
    的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外空间复杂度请达到O(1)。
    思路：先判断链表有环还是无环并返回第一个相交的节点，再判断链表相交问题（有环相交和无环相交，一个有环一个无环不可能相交）
 */
public class FindFirstIntersectNode {
    public class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    //获得链表的长度
    public int getLength(Node head) {
        if (head==null)
            return 0;
        int len = 0;
        while (head!=null) {
            len++;
            head = head.next;
        }
        return len;
    }
    public Node getIntersectNode(Node head1, Node head2) {
        if (head1==null||head2==null)
            return null;
        Node loop1 = getLoppNode(head1);
        Node loop2 = getLoppNode(head2);
        if (loop1==null&&loop2==null) {  //两个无环链表的相交问题
            return noLoopNode(head1,head2);
        }
        if (loop1!=null&&loop2!=null) {  //两个有环链表的相交问题
            return bothLoopNode(head1,loop1,head2,loop2);
        }
        return null;
    }
    //判断单链表是否有环，并返回第一个入环节点,不使用辅助空间的方法
    public Node getLoppNode(Node head) {
        if (head==null)
            return null;
        Node fast=head,slow=head;
        while (fast!=slow) {  //若fast==slow相遇，则说明有环但可能不是第一个入环节点
            if (fast.next==null||fast.next.next==null) //fast为null，则说明无环
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head; //fast从头结点开始，每次走一步，slow从相遇点开始，每次走一步，直到相遇点为第一个入环节点
        while (fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    //返回无环链表的第一个相交节点
    public Node noLoopNode(Node head1,Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        if (len1>len2) {   //长度较长的链表先走，直到走到长度相同为止
            while (len1!=len2) {
                head1 = head1.next;
                len1--;
            }
        }else {
            while (len1!=len2) {
                head2 = head2.next;
                len2--;
            }
        }
        //然后，同时开始走，直到相遇为止，就是第一个相交节点
        while (head1!=head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
    //返回有环链表的第一个相交节点，分为有环相交和有环不相交,入环节点与相交节点不一定是同一个节点
    public Node bothLoopNode(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1=null;
        Node cur2=null;
        //分为入环节点相等和不等
        if (loop1==loop2) {
            cur1=head1;
            cur2=head2;
            int len1=0,len2=0;
            while (cur1!=loop1) {
                len1++;
                cur1=cur1.next;
            }
            while (cur2!=loop2) {
                len2++;
                cur2=cur2.next;
            }
            if (len1>len2) {   //长度较长的链表先走，直到走到长度相同为止
                while (len1!=len2) {
                    cur1=cur1.next;
                    len1=len1-1;
                }
            }else {
                while (len1!=len2) {
                    cur2 = cur2.next;
                    len2--;
                }
            }
            //然后，同时开始走，直到相遇为止，就是第一个相交节点
            while (cur1!=cur2) {
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }
        else{
            cur1=loop1.next;
            while (cur1!=loop1) {
                if (cur1==loop2)
                    return loop1;
                cur1=cur1.next;
            }
            return null;
        }
    }

}
