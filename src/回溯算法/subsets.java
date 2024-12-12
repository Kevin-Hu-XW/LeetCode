package 回溯算法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
    求子集和组合类似，子集是0~n所有组合的集合


 */
public class subsets {
    List<List<Integer>> paths = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int i=0;i<=nums.length;i++){     //0~n所有组合的集合
            backtracking(nums,i,0);
        }
        return paths;
    }
    public void backtracking(int[] nums,int k,int startIndex){  //k代表取几个元素进行组合
        if (path.size()==k){      //递归终止条件
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,k,i+1);
            path.removeLast();
        }
    }
    /*
        也可以理解为遍历树上的每一个节点

        List<List<Integer>> paths = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        public List<List<Integer>> subsets(int[] nums) {
            if(nums.length==0) return paths;
            backtracking(nums,0);
            return paths;
        }
        public void backtracking(int[] nums,int startIndex){
            paths.add(new ArrayList<>(path)); //添加遍历的每一个节点
            if(startIndex>=nums.length){
               return ;
            }
            for(int i=startIndex;i<nums.length;i++){
                path.add(nums[i]);
                backtracking(nums,i+1);
                path.removeLast();
            }
        }
     */
}
