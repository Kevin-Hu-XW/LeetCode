package BinaryTree;

import java.awt.dnd.DragSourceDragEvent;

/*
    判断是否是搜索二叉树
    利用中序遍历，如果遍历结果是升序，则是搜索二叉树，否则不是
    先判断左子树，在判断右子树
 */
public class SearchBinaryTree {
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
    long min = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if (root==null)
            return true;
        //访问左子树
        boolean left = inorder(root.left);
        if (!left)
            return false;
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (min>=root.val){
            return false;
        }
        min = root.val;
        //访问右子树
        boolean right = inorder(root.right);
        if (!right)
            return false;
        return true;
    }
}
