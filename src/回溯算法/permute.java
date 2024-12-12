package 回溯算法;

import java.util.*;

/*
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    思路：回溯算法
    boolean[] used = new boolean[nums.length];来记录元素是否被访问过
 */
public class permute {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> track = new ArrayDeque<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums,track,used);
        return res;
    }
    public void backtrack(int[] nums,Deque<Integer> track,boolean[] used){
        if (track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!used[i]){
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums,track,used);
                used[i] = false;
                track.removeLast();
            }

        }
    }
}
