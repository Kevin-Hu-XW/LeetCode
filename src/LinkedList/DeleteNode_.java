package LinkedList;
/*
    请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
    思路：
    由于只能访问到被删除的节点，而无法访问到被删除节点的前驱节点。
    因此，不能通过其前驱节点和后继节点来删除当前节点。
    可以用被删除节点的后继节点（假设为节点 a）的节点值覆盖要被删除节点的节点值，然后将节点 a 删除。
 */
public class DeleteNode_ {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
