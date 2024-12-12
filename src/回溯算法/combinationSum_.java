package 回溯算法;

import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class combinationSum_ {
    static List<List<Integer>> paths = new ArrayList<>();
    static Deque<Integer> path = new ArrayDeque<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates,target,0,0);
        return paths;
    }
    public static void backtracking(int[] candidates,int target,int sum,int startIndex){
        //if(sum>target)  //sum>target就结束，sum==target也结束
        //return;
        if(sum==target){
            paths.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            if(sum+candidates[i]>target) break;  //提前进行判断，不用进入下一个递归中判断
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates,target,sum,i); //startIndex为i，不是i+1，表示可以取重复元素
            path.removeLast();
            sum -= candidates[i];
        }

    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> res = combinationSum(candidates,7);
        System.out.println(res.get(0));
    }
}
