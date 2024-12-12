package BinaryTree;

import java.util.Stack;
//所有的节点都可看做是父节点(叶子节点可看做是两个孩子为空的父节点)。
public class PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    /*
        递归遍历
     */
    public void preOrder(Node node) {
        if (node==null)
            return ;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(Node node) {
        if (node==null)
            return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
    public void posOrder(Node node) {
        if (node==null)
            return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }


    /*
        非递归先序遍历,根左右
     */
    public void preOrderUnRecur(Node node) {
        if (node==null)
            return;
        Stack<Node> stack = new Stack<Node>();
        while (!stack.empty()||node!=null) {

            while (node!=null) {
                System.out.println(node.value);
                stack.push(node);
                node = node.left;
            }
            //当node为空时，说明根和左子树都遍历完了，这时需要弹出根节点，用来访问右子树，
            if (!stack.empty()) {
                node=stack.pop();
                //进入右子树，开始新的一轮左子树遍历(这是递归的自我实现)
                node = node.right;
            }


        }
    }
    //先序遍历方法二，根左右
    public void preOrderUnRecur1(Node node) {
        if (node==null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (!stack.empty()) {
            node = stack.pop();
            System.out.println(node.value);
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }
    }


    /*
        非递归中序遍历，左根右，先从左子树的最下边的节点开始遍历
     */
    public void inOrderUnRecur(Node node) {
        if (node==null)
            return;
        Stack<Node> stack = new Stack<Node>();
        //需要利用栈结构进行遍历，因为遍历完左子树后，需要通过根节点进行访问右子树
        while (!stack.empty()||node!=null) {     //当栈中的元素为空，则二叉树遍历结束
            //一直遍历到左子树最下边，边遍历边保存根节点到栈中
            while (node!=null) {
                stack.push(node);
                node = node.left;
            }
            /*
                node为空时，说明已经到达左子树最下边，这时需要弹出根节点，用来访问右子树，
                注意出栈前一定要判断是否为空！
             */
            if (!stack.empty()) {
                node = stack.pop();
                System.out.println(node.value);
                //进入右子树，开始新的一轮左子树遍历(这是递归的自我实现)
                node = node.right;
            }
        }
    }

    /*
        后序遍历,前序遍历右子树先入栈，左子树后入栈，后序遍历左子树先入栈，右子树后入栈
     */
    public void posOrderUnRecur(Node node) {
        if (node==null)
            return;
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> pos = new Stack<Node>();
        stack.push(node);
        while (!stack.empty()) {
            node = stack.pop();
            pos.push(node);
            if (node.left!=null)
                stack.push(node.left);
            if (node.right!=null)
                stack.push(node.right);
        }
        while (!pos.empty()) {
            System.out.println(pos.pop().value+" ");
        }
    }
    public static void main(String[] args) {

    }
}
