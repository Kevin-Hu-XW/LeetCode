package BinaryTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
    思路：动态规划
    通过深度优先遍历把元素存储到数组，再进行计算出最大金额
 */
public class Rob_ {
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

    Stack<TreeNode> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    public int rob_III(TreeNode root) {
        if (root==null)
            return 0;
        stack.push(root);
        TreeNode node;
        while (!stack.isEmpty()){
            node = stack.pop();
            list.add(node.val);
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }
        int[] nums = new int[list.size()];
        for (int i=0;i<nums.length;i++){
            nums[i] = list.get(i);
        }
        if (nums.length==1)
            return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0],nums[1]);
        int temp;
        for (int i=2;i<nums.length;i++){
            temp = second;
            second = Math.max(second,first+nums[i]);
            first = temp;
        }
        return second;
    }
}
