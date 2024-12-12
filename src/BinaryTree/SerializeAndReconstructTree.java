package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
    二叉树的序列化和反序列化

 */
public class SerializeAndReconstructTree {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    //序列化
    public String serializeByPre(Node node) {
        if (node==null)
            return "#!";
        String res=node.value+"!";
        res+=serializeByPre(node.left);
        res+=serializeByPre(node.right);
        return res;
    }
    //反序列化
    public Node reconByPreString(String res) {
        String[] values =res.split("!");
        Queue<String> queue =new LinkedList<String>();
        for (int i= 0;i<values.length;i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    public Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#"))
            return null;
        Node node = new Node(Integer.valueOf(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }
}
