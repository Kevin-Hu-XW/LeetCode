package BinaryTree;

import java.sql.PseudoColumnUsage;

/*
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
    如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
    思路：根据二叉搜索树的定义，可以通过递归，判断所有子树的正确性（即其后序遍历是否满足二叉搜索树的定义），
          若所有子树都正确，则此序列为二叉搜索树的后序遍历
 */
public class verifyPostorder_ {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length==0)
            return true;
        return recur(postorder,0,postorder.length-1);
    }
    public boolean recur(int[] postorder,int i,int j){
        if (i>=j)
            return true;
        int p=i;
        //判断左子树的值是否比根节点小，并找出右子树的开始节点
        while (postorder[p]<postorder[j])
            p++;
        int m = p;
        //判断右子树所有的点的值是否比根节点大
        while (postorder[p]>postorder[j])
            p++;
        //根据p==j来判断所有右子树的节点的值是否大于根节点
        return p==j&&recur(postorder,i,m-1)&&recur(postorder,m,j-1);

    }
}
