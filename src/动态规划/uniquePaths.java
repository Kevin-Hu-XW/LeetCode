package 动态规划;
/*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？
    思路：构造二维dp数组，根据初始状态和状态方程，进行迭代计算出所有不同路径，
          注意判断边界值
 */
public class uniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                //初始值
                if (i==1&&j==1)
                    dp[i][j] = 1;
                else if (i==1){
                    dp[i][j] = dp[i][j-1];
                }
                else if (j==1){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    //状态方程
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
