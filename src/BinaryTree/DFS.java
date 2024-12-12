package BinaryTree;



import java.util.Stack;

/*
    深度优先遍历
    递归方法：就是前序遍历
 */
public class DFS {
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
    //非递归方法
    public void unRecursiveDFS(TreeNode node){
        if (node == null)
            return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.val+" ");
            if (temp.right!=null) {
                stack.push(temp.right);
            }
            if (temp.left!=null){
                stack.push(temp.left);

            }

        }
    }
}
