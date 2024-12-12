package BinaryTree;
import java.awt.event.FocusEvent;
import java.util.*;
/*
    给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，
    再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    思路：在层次遍历的基础上，统计每层节点的个数，并添加到list中设，间隔反转一次，加入List中
 */
public class zigzagLevelOrder {
    public static class TreeNode {
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = null;
        List<Integer> list1 = null;
        queue.offer(root);
        int count=1;
        while (!queue.isEmpty()){
            int size = queue.size();
            //循环遍历每层节点
            list1 = new ArrayList<>();
            for (int i=0;i<size;i++){
                node = queue.poll();
                list1.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            if(count%2==0){
                List<Integer> list2 = new ArrayList<>();
                for (int i=list1.size()-1;i>=0;i--){
                    list2.add(list1.get(i));
                }
                list.add(list2);
            }else {
                list.add(list1);
            }
            count++;

        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        zigzagLevelOrder(node);
    }
}
