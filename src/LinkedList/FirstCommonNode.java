package LinkedList;

import java.util.HashSet;

/*  无环链表相交问题
    两个链表的第一个公共节点，指的是内存地址相等的第一个节点
    方法一：先把第一个链表的节点全部存放到集合set中，然后遍历第二个链表的每一个节点，
           判断在集合set中是否存在，如果存在就直接返回这个存在的结点。如果遍历完了，
           在集合set中还没找到，说明他们没有相交，直接返回null即可，
    方法二：还可以先统计两个链表的长度，如果两个链表的长度不一样，
           就让链表长的先走，直到两个链表长度一样，这个时候两个链表再同时每次往后移一步，
           看节点是否一样，如果有相等的，说明这个相等的节点就是两链表的交点，
           否则如果走完了还没有找到相等的节点，说明他们没有交点，直接返回null即可
    方法三：双指针法，如果A指针把链表A走完了，然后再从链表B开始走到相遇点就相当于把这两个链表的所有节点都走了一遍，
            同理如果B指针把链表B走完了，然后再从链表A开始一直走到相遇点也相当于把这两个链表的所有节点都走完了
            所以如果A指针走到链表末尾，下一步就让他从链表B开始。同理如果B指针走到链表末尾，下一步就让他从链表A开始。
            只要这两个链表相交最终肯定会在相交点相遇，如果不相交，最终他们都会同时走到两个链表的末尾，
 */
public class FirstCommonNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //方法一
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) {
            return null;
        }
        HashSet<ListNode> set=new HashSet<ListNode>();
        while (headA!=null) {
            set.add(headA);
            headA=headA.next;
        }
        while (headB!=null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }

    //方法二:不使用额外空间
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) {
            return null;
        }
        int lenA=ListNodeLength(headA);
        int lenB=ListNodeLength(headB);
        //如果节点长度不一样，节点多的先走，直到他们的长度一样为止
        while (lenA!=lenB) {
            if(lenA>lenB){
                //如果链表A长，那么链表A先走
                headA=headA.next;
                lenA--;
            }
            else {
                //如果链表B长，那么链表B先走
                headB=headB.next;
                lenB--;
            }
        }
        while (headA!=headB) {
            headA=headA.next;
            headB=headB.next;
        }
        //走到最后，最终会有两种可能，一种是headA为空，
        //也就是说他们俩不相交。还有一种可能就是headA
        //不为空，也就是说headA就是他们的交点
        return headA;
    }
    public int ListNodeLength(ListNode node){
        if (node!=null){
            int len=0;
            while (node!=null) {
                len++;
                node=node.next;
            }
            return len;
        }
        return 0;

    }





    //方法三：双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) {
            return null;
        }
        ListNode tempA=headA;
        ListNode tempB=headB;
        while (tempA!=tempB) {
            //如果指针tempA不为空，tempA就往后移一步。
            //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
            tempA=tempA==null?headB:tempA.next;
            tempB=tempB==null?headA:tempB.next;
        }
        return tempA;
    }
     public static void main(String[] args) {

    }
}
