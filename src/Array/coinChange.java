package Array;

import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for (int j=0;j<coins.length;j++){
                if (i-coins[j]>=0&&dp[i-coins[j]]!=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);   //获取所有dp[i-coins[j]]的最小值
            }
        }
        if (dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];


    }
}
