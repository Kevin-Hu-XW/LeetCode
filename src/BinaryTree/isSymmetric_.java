package BinaryTree;
/*
    判断树是否对称：
    即此两对称节点值相等。
    即L的左子节点和R的右子节点对称；
    即L的右子节点和R的左子节点对称。
    终止条件：
    当 L和 R同时越过叶节点：此树从顶至底的节点都对称，因此返回true
    当 L或 R中只有一个越过叶节点：此树不对称，因此返回false
    当节点 L值\=节点R值：此树不对称，因此返回false
 */
public class isSymmetric_ {
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
    public boolean isSymmetric(TreeNode root) {
        return root==null?true:recure(root.left,root.right);
    }
    private boolean recure(TreeNode L, TreeNode R) {
        if (L==null&&R==null) return true;
        if (L==null||R==null) return false;    //不平衡，只有一个节点为空
        return (L.val==R.val)&&recure(L.left,R.right)&&recure(L.right,R.left);
    }

}
