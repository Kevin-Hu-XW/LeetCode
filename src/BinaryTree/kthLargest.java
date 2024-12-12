package BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

/*
    给定一棵二叉搜索树，请找出其中第k大的节点。
    思路：中序遍历进队，然后返回第K个出队节点
 */
public class kthLargest {
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
    int count = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    public int kthSmallest(TreeNode root, int k) {
        queue = push(root);
        int res = 0;
        while (!queue.isEmpty()){
            count++;
            if (count==k){
                res = queue.poll().val;
                break;
            }
            queue.poll();
        }
        return res;

    }
    public Queue<TreeNode> push(TreeNode root){
        if (root!=null){
            push(root.left);
            queue.offer(root);
            push(root.right);
        }
        return queue;
    }

}
