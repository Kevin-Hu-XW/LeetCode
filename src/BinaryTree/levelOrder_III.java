package BinaryTree;
import java.util.*;
/*
    请实现一个函数按照之字形顺序打印二叉树，
    即第一行按照从左到右的顺序打印，
    第二层按照从右到左的顺序打印，
    第三行再按照从左到右的顺序打印，其他行以此类推。
    方法：层序遍历需要报每一层节点放在一个list中，要统计每层节点的个数
         首先根节点入队
         求当前队列的长度
         依次从队列中第i个元素进行拓展，然后进入下一次迭代
         通过count值判断，该层元素是否需要反转
 */
public class levelOrder_III {
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
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<TreeNode> queue = new LinkedList<>();
    static TreeNode node = null;
    static int levelSize=0;
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        queue.offer(root);
        int count=1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            levelSize = queue.size();
            //遍历一层节点
            for (int i=0;i<levelSize;i++) {
                node = queue.poll();
                level.add(node.val);
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }
            //偶数层反转
            if (count/2==0){
                int[] res = new int[level.size()];
                int j=0;
                for(int i=level.size()-1;i>=0;i--) {
                    res[j++] = level.get(i);
                    System.out.println(res[j]);
                }
                List<Integer> level1 = new ArrayList<>();
                for(int k=0;k<res.length;k++) {
                    level1.add(res[k]);
                }
                list.add(level1);
            }else{
                list.add(level);
            }
            count++;
        }

        return list;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        levelOrder(node);
    }
}
