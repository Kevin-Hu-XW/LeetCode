package 动态规划;
/*
    我们把只包含质因子2、3和5的数称作丑数（Ugly Number）。求按从小到大的顺序的第n个丑数。
    思路：丑数只包含因子2,3,5 ，因此有 “丑数 == 某较小丑数*某因子”，则丑数为dp[i-1]*2,dp[i-1]*3,dp[i-1]*5
          中的最小值
 */
public class nthUglyNumber_ {
    public static int nthUglyNumber(int n) {
        //状态初始值设置
        int[] dp = new int[n];
        dp[0] = 1;
        int a=0,b=0,c=0;
        for (int i=1;i<n;i++){
            //状态方程
            dp[i] = Math.min(Math.min(dp[a]*2,dp[b]*3),dp[c]*5);
            if (dp[i]==dp[a]*2) a++;
            if (dp[i]==dp[b]*3) b++;
            if (dp[i]==dp[c]*5) c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
