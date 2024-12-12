package BinaryTree;

/*
    已知一棵完全二叉树，求其节点的个数
    要求：时间复杂度低于O(N)，N为这棵树的节点个数
    情况1.先遍历左子树，记录最大深度h,在遍历右子树的最左边界的深度到最后一层h,则左子树是高度为h的完全二叉树，递归求右子树
    情况2.若在遍历右子树的最左边界的深度没有最后一层h，则右子树是高度为h-1的满二叉树，递归求左子树
    总结：每次遍历一个节点，判断其右树的左边界有没有到最后一层，到了左树的满二叉树，没到右树是满二叉树，递归求剩下的节点
    level：当前节点所在的层数
    h:二叉树的最大深度
 */
public class CompleteTreeNodeNumber {
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
    public int TreeNodeNumber(TreeNode node) {
        if (node==null)
            return 0;

        return NodeNumber(node,1,mostleftDeep(node,1));
    }
    public int NodeNumber(TreeNode node,int level,int h) {
        if (level==h)
            return 1;
        //右树的左边界有没有到最后一层，到了左树的满二叉树，递归求剩下的节点
        if (mostleftDeep(node.right,level+1)==h) {
            return (1<<(h-level))+NodeNumber(node.right,level+1,h);
        }
        else {
            //没到右树是满二叉树，递归求剩下的节点
            return (1<<(h-level-1))+NodeNumber(node.left,level+1,h);
        }
    }
    //右子树的最左边界的深度
    public int mostleftDeep(TreeNode node,int level) {
        if (node==null)
            return 0;
        while (node!=null) {
            level++;
            node = node.left;
        }
        return level-1;
    }
}
