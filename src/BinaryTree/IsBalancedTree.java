package BinaryTree;


/*
    判断以node为头结点的二叉树数是不是平衡树
    思路：1.左子树是否平衡
          2.右子树是否平衡
          3.左树和右树的高度
          4.判断左树和右树的高度差
 */
public class IsBalancedTree {
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
    public class ReturnData{
        public int h;
        public boolean isB;
        public ReturnData(boolean isB,int h) {
            this.isB = isB;
            this.h = h;

        }
    }
    public boolean isBalence(TreeNode node) {
        return process(node).isB;
    }
    public ReturnData process(TreeNode node){
        if(node==null)
            return new ReturnData(true,0);
        ReturnData leftData = process(node.left);
        if (!leftData.isB)
            return new ReturnData(false,0);
        ReturnData rightData = process(node.right);
        if (!rightData.isB)
            return new ReturnData(false,0);
        if (Math.abs(leftData.h-rightData.h)>1)
            return new ReturnData(false,0);
        return new ReturnData(true,Math.max(leftData.h,rightData.h)+1);
    }
}
