package BinaryTree;

import java.util.ArrayList;
import java.util.List;
/*
    给你二叉树的根结点 root ，请你将它展开为一个单链表(先序遍历)
    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    思路：按照先序遍历的方式，把节点添加到list中，
          然后按照其中 right 子指针指向链表中下一个结点，而左子指针始终为 null的方式进行设置

 */
public class TreeToList {
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
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root==null)
            return;
       preOrder(root);
       TreeNode node = new TreeNode(0);
       TreeNode cur = node;
       for (int i=0;i<list.size();i++) {
           cur.right=list.get(i);
           cur.left=null;
           cur = cur.right;
       }
       node = node.right;
    }
    public void preOrder(TreeNode root) {
        if (root==null)
            return;
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
