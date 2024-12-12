package BinaryTree;
/*
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    思路：满足p.val <root.val<q.val的值为最近公共祖先
    root是p、q的最近公共祖先，有以下三种可能：
    1、p,q在root的子树中，即分别在左右子树
    2、p==root,p在root的左子树或右子树
    3、q==root,q在root的左子树或右子树
 */
public class lowestCommonAncestor_I {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (root!=null){
                if (p.val<root.val&&q.val<root.val){
                    root = root.left;
                }
                else if (p.val>root.val&&q.val>root.val){
                    root = root.right;
                }else{
                    break;
                }
            }
            return root;
    }
}
