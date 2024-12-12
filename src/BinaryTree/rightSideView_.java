package BinaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    思路：使用层次遍历，每层保留最后一个节点，保证每层最后一个节点入队，才是正确结果
 */
public class rightSideView_ {
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
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null)
            return new ArrayList<>(0);
        TreeNode node = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++) {
                node = queue.poll();
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
                if (i==size)
                    list.add(node.val);
            }
        }
        return list;
    }
}
