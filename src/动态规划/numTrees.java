package 动态规划;
/*
    给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的
    二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
    G(n) = F(1,n)+.....+F(n,n)
    F(1,n) = G(0)*G(n-1)
 */
public class numTrees {

    public int numTrees(int n) {
        if (n==1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int temp=0;
        for (int i=3;i<=n;i++){
            for (int j=1;j<=i;j++){
                temp =temp + dp[j-1]*dp[i-j];
            }
            dp[i] = temp;
            temp = 0;   //重新赋值为0，进行下一个点的计算
        }
        return dp[n];
    }
}
