package 动态规划;

public class longestPalindrome {
    public static String longestPalindrome(String s) {
        int len=0,max=Integer.MIN_VALUE;
        //进行标记最大回文串的索引下标
        int start=0,end=0;
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        //遍历顺序从下到上，从左到右，因为dp[i][j]需要通过dp[i+1][j-1]来判断
        for (int i=s.length()-1;i>=0;i--){
            for (int j=i;j<s.length();j++){
                /*
                    情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
                    情况二：下标i 与 j相差为1，例如aa，也是文子串
                    情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，
                            我们看i到j区间是不是回文子串就看aba是不是回文就可以了，那么aba的区间就是 i+1 与 j-1区间，
                            这个区间是不是回文就看dp[i + 1][j - 1]是否为true
                 */
                if (str[i]==str[j]){
                    if (j-i<=1){
                        dp[i][j] = true;
                        if (max<j-i){
                            start = i;
                            end = j;
                            max = j-i;
                        }
                    }
                    else if (dp[i+1][j-1]){
                        dp[i][j] = true;
                        if (max<j-i){
                            start = i;
                            end = j;
                            max = j-i;
                        }
                    }
                }
            }
        }
        String res = "";
        for (int i =start;i<=end;i++){
            res = res+str[i];
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
