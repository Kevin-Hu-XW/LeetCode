package 回溯算法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
            Deque<Integer> path = new ArrayDeque<>();
 */
public class combine {
    List<List<Integer>> paths = new ArrayList<>();   //存放最后结果
    Deque<Integer> path = new ArrayDeque<>();    //存放每次遍历的路劲
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return paths;
    }
    public void backtracking(int n,int k,int startIndex){
            if (path.size()==k){      //递归终止条件
                paths.add(new ArrayList<>(path));
                return;
            }
            for (int i=startIndex;i<n;i++){
                path.add(i);
                backtracking(n,k,i+1);   //程序结束后
                path.removeLast();   //当程序结束时，即到达叶子节点，需要回溯
            }
    }
}
