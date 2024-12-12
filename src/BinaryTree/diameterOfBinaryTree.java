package BinaryTree;
/*
    给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
    这条路径可能穿过也可能不穿过根结点。
    思路：以每一个节点为中心节点，保存长度的最大值，利用左子树的深度+右子树的深度+1，即为医改的为中心的二叉树直径

 */
public class diameterOfBinaryTree {
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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        res= 1;
        int maxLength = deep(root);
        return res-1;   //长度为节点数减一
    }
    public int deep(TreeNode node){
        if (node==null)
            return 0;
        int left= deep(node.left);
        int right = deep(node.right);
        res = Math.max(res,left+right+1);
        return Math.max(left,right)+1;

    }

}
