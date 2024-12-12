package 动态规划;

import java.util.Arrays;
/*
    最长递增序列
 */
public class lengthOfLIS_ {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==1) return 1;
        int[] dp = new int[nums.length];  //dp[i]代表i之前包括i的最长严格递增子序列的长度，但又不是，因为最后还要取最大值
        Arrays.fill(dp,1);  //初始化
        int res = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
