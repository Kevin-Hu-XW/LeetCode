package BinaryTree;
import java.util.*;
/*
    层序遍历需要报每一层节点放在一个list中，要统计每层节点的个数
    首先根节点入队
    求当前队列的长度
    依次从队列中第i个元素进行拓展，然后进入下一次迭代
 */
public class LevelOrder {
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
    List<List<Integer>> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode node = null;
    public int[][] levelOrder(TreeNode root) {
        if (root==null)
            return new int[0][0];
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            //统计每一层的节点数
            int levelSize = queue.size();
            //把每一层节点添加到ArrayList中
            for (int i=0;i<levelSize;i++) {
                node = queue.poll();
                level.add(node.val);
            /*
                层次遍历需要从左到右，所以入队时先入左节点，后入右节点
             */
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }
            list.add(level);

        }
        int[][] res = new int[list.size()][];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }
}
