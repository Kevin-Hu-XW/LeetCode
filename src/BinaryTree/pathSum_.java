package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
    返回满足给定目标的所有二叉树路径
    思路：通过深度优先遍历
    注意：值传递与引用传递
 */
public class pathSum_ {
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
    static List<List<Integer>> list = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root==null)
            return new ArrayList<>();
        List<List<Integer>> paths = new LinkedList<>();
        allPaths(root,new ArrayList<>());
        int count;
        for (List<Integer> path:list){
            count=0;
            for (int i=0;i<path.size();i++){
                count=count+path.get(i);
            }
            if (count==target)
                paths.add(path);
        }
        return paths;
    }
    public static void allPaths(TreeNode root,List<Integer> list1){
        if (root!=null){
            list1.add(root.val);
            //当到根节点时，将该路径添加到列表
            if (root.left==null&&root.right==null){
                list.add(new LinkedList<>(list1));
                /*
                    到达叶子节点需要回退一个节点
                 */
                list1.remove(list1.size()-1);
                return;
            }
            allPaths(root.left,list1);
            allPaths(root.right,list1);
            /*
                左右节点都遍历完，需要回退一个节点
             */
            list1.remove(list1.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.left.left = new TreeNode(12);
        node.right.right = new TreeNode(1);
        List<List<Integer>> list = pathSum(node,24);
        for (List<Integer> path:list){
            for (int i=0;i<path.size();i++){
                System.out.println(path.get(i));
            }

        }
    }
}
