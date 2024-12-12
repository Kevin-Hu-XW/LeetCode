package BinaryTree;
import java.util.Stack;
/*
    node，请实现返回node的后继节点的函数。
    在二叉树的中序遍历的序列中，node的下一个节点叫作node的后继节点。
 */
public class SuccessorNode {
    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int data) {
            this.value = data;
        }
    }
    public Node Successor(Node node) {
        if (node==null) {
            return null;
        }
        if (node.right!=null) {
            return getNodeMostLeft(node.right);
        }
        else {    //node节点没有右子树，则需考虑该节点属于那个节点的左子树的最后一个节点
            Node parent = node.parent;
            while (parent!=null&&parent.left!=node) {  //当前节点是父节点的左孩子停止
                node = parent;
                parent= node.parent;
            }
            return parent;
        }
    }

    public Node getNodeMostLeft(Node node) {
        if (node==null)
            return null;
        Stack<Node> stack = new Stack<Node>();
        while (node!=null) {
            stack.push(node);
            node = node.left;
        }
        return stack.pop();
    }


}
