package BinaryTree;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.*;

/*
    层序遍历需要报每一层节点放在一个list中，要统计每层节点的个数
    首先根节点入队
    求当前队列的长度
    依次从队列中第i个元素进行拓展，然后进入下一次迭代
    利用Collections.reverse(list)或栈对list进行反转
 */
public class LevelOrder_II {
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
    Stack<List<Integer>> stack = new Stack<>();
    TreeNode node = null;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
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
            stack.add(level);
        }
        //Collections.reverse(list);
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
