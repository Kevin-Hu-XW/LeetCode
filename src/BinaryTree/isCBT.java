package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
    判断是否是完全二叉树,分为两种情况：
    1.一个节点有右孩子，没有左孩子，返回false
    2.如果一个节点只有左孩子或者该节点为叶子节点，则在它后面的节点中都是叶子节点，否则返回false
    3.若这两种情况在遍历时都没有发生，则返回true
 */
public class isCBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean iscbTree(TreeNode node) {
        if (node==null)
            return true;
        //层次遍历来遍历二叉树，层次遍历利用队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Boolean leaf = false;
        queue.offer(node);
        while(!queue.isEmpty()) {
            //层次遍历根节点先出队列
            node = queue.poll();
            //所有不满足完全二叉树的情况，只要符合一种情况就返回false
            if (/*情况二，leaf开启后，即后面的节点不能有左子树或者右子树*/(leaf&&(node.left!=null||node.right!=null))||
                /*情况一*/(node.left==null&&node.right!=null))
                return false;
            //然后，左右子树分别入队
            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.offer(node.right);
            if ((node.left!=null&&node.right==null)||(node.left==null&&node.right==null))
                leaf=true;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(false&&false);
    }
}
