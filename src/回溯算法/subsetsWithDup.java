package 回溯算法;

import java.util.*;

public class subsetsWithDup {
    List<List<Integer>> paths = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);    //使数组转为有序数组
        for(int i=0;i<=nums.length;i++){
            backtracking(nums,i,0);
        }
        paths = new ArrayList<List<Integer>>(new HashSet<List<Integer>>(paths));
        return paths;
    }
    public void backtracking(int[] nums,int k,int startIndex){
        if(path.size()==k){
            paths.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,k,i+1);
            path.removeLast();
        }
    }

}
