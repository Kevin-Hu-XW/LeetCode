package LinkedList;
import java.util.HashMap;
/*
  复制链表：
  请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
  每个节点除了有一个 next 指针指向下一个节点，还有一个 random
  指针指向链表中的任意节点或者 null。

  方法：利用hash表利用哈希表的查询特点,考虑构建
        原链表节点和新链表对应节点 的键值对映射关系，再遍历构建新链表各节点的next和random引用指向即可。
  方法二：考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，如此便可在访问原节点的
         random 指向节点的同时找到新对应新节点的 random 指向节点。
 */
public class CopyListWithRandom {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //方法一：hash表
    public Node copyRandomList1(Node head) {
        if (head==null) {
            return null;
        }
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        while (cur!=null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur!=null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random= map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    //方法二：hash表
    public Node copyRandomList2(Node head) {
        if (head==null) {
            return null;
        }
        Node cur = head;
        Node temp;
        //在每个节点后添加新的节点
        while (cur!=null) {
            temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;  //移动到下一个要进行添加新节点的位置
        }
        cur = head;
        //设置新节点的random指针
        while (cur!=null) {
            //random值可能为null，所以需要做一个三目运算判断
            cur.next.random = cur.random==null?null:cur.random.next;
            //cur.next一定存在，所以只需把cur.next.next赋给cur即可
            cur = cur.next.next;
        }
        //将链表拆分开来
        Node pre = head;
        Node node = head.next,current = head.next;
        while (current.next!=null) {
            pre.next = current.next;
            //原链表的指针移动下一位
            pre = pre.next;
            //新链表的节点进行链接
            current.next = pre.next;
            current = current.next;
        }
        pre.next=null;
        return node;
    }
    public static void main(String[] args) {

    }
}
