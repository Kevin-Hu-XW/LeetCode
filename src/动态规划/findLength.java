package 动态规划;
/*
    dp[i][j]表示A[i:],B[j:]的最长公共前缀
    如果A[i]==B[j]，即dp[i][j]=dp[i+1][j+1]+1
    否则，dp[i][j]=0
 */
public class findLength {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int ans = 0;
        int[][] dp = new int[n+1][m+1];
        for (int i=n-1;i>=0;i--){
            for (int j=m-1;j>=0;j--){
                dp[i][j]=nums1[i]==nums2[j]?dp[i+1][j+1]+1:0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
