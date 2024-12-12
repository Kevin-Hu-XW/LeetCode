package Array.两数相加;

public class MyListNode {

    //向链表中插入数据
    public void addNode(ListNode head,int data){
        ListNode newnode=new ListNode(data);
        if(head==null){     //尾插法
            head = newnode;
            return ;
        }
        ListNode current=head;
        while(current.next!=null){
            current=current.next;
        }

        current.next=newnode;
    }
    //打印链表
    public void PrintLinkedNode(ListNode head){
        ListNode current =head;
        while(current.next!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
}
