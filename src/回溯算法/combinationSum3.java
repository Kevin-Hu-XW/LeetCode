package 回溯算法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class combinationSum3 {
    static List<List<Integer>> paths = new ArrayList<>();
    static Deque<Integer> path = new ArrayDeque<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1,0);
        return paths;
    }
    public static void backtracking(int k, int n,int satrtIndex,int sum){
        if (path.size()==k){
            if (n==sum)
                paths.add(new ArrayList<>(path));
            return;
        }
        for (int i=satrtIndex;i<=9;i++){
            sum += i;
            if (sum>n)
                return;
            path.add(i);
            backtracking(k,n,i+1,sum);
            sum = sum-i;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3,7);
        System.out.println(res.get(0));
    }
}
