package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code1 {
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
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode node = null;
    public int[] levelOrder(TreeNode root) {
        if (root==null)
            return new int[0];
        queue.offer(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            list.add(node.val);
            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        int[] res =new int[list.size()];
        for (int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }





}
