package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    三数之和是固定一个数，移动两个数进行判断
    四数之和是固定两个数，移动另外两个数进行判断
 */
public class fourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums==null||nums.length<4)
            return res;
        for (int i=0;i<nums.length-3;i++) {
            //去重
            if (i>0&&nums[i]==nums[i-1]) continue;
            for (int j=i+1;j<nums.length-2;j++) {
                //去重
                if (j>i+1&&nums[j]==nums[j-1]) continue;
                int l=j+1;
                int r=nums.length-1;
                int partSum = nums[i]+nums[j];
                while (l<r) {
                    int sum = partSum+nums[l]+nums[r];
                    if (sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;r--;
                        //去重
                        while (l<r&&nums[l]==nums[l-1]) l++;
                        while (l<r&&nums[r]==nums[r+1]) r--;
                    }else if (sum<target){
                        l++;
                    }else {
                        r--;
                    }

                }
            }
        }
        return res;
    }
}
