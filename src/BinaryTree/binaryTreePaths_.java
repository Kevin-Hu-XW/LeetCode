package BinaryTree;
/*
    给定一个二叉树，返回所有从根节点到叶子节点的路径。
    思路：DFS
 */
import java.util.*;
public class binaryTreePaths_ {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        allPaths(root,"",paths);
        return paths;
    }
    public void allPaths(TreeNode node,String path,List<String> paths){
        if (node!=null){
            StringBuilder str = new StringBuilder(path);
            str.append(String.valueOf(node.val));
            if (node.left==null&&node.right==null){
                //叶子结点添加路径
                paths.add(str.toString());
                return;
            }
            else {
                //当节点不是叶子节点才会添加->
                str.append("->");
                //分别在遍历左右子树
                allPaths(node.left,str.toString(),paths);
                allPaths(node.right,str.toString(),paths);
            }

        }
    }
}
