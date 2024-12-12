package 动态规划;
/*
    给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
    思路：中心向外扩散方法，一个回文串中既有偶数回文串，也有奇数回文串，一个回文串共有2N-1个回文中心
    枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，当两个指针指向的元素相同的时候就拓展，否则停止拓展

 */
public class countSubstrings_ {
    //中心扩展法
    public int countSubstrings(String s) {
        //使用中心扩展法
        //如果回文子串长度为奇数, 则其中心分别为s[0], s[1], ... s[s.length()-1]
        //如果回文子串长度为偶数, 则其中心为空
        int strLen = s.length();
        int total = 0;
        for(int i = 0; i < strLen ; i++){
            //首先判断长度为奇数的回文子串
            int left = i;
            int right = i;
            while(left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)){
                total++;
                left--;
                right++;
            }
            //判断长度为偶数的回文子串
            left = i;
            right = i+1;
            while(left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)){
                total++;
                left--;
                right++;
            }
        }
        return total;
    }
    //动态规划
    /*
       什么是回文
       1、单个字符串
       2、两个字符串组成，且字符相同
       3、超过两个字符串，首尾字符相同，且剩余子串是回文串
     */
    public int countSubstrings1(String s) {
        int len=0,res=0;
        char[] str = s.toCharArray();
        if (s==null||s.length()<1)
            return 0;
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
                        res++;
                        dp[i][j] = true;
                    }
                    else if (dp[i+1][j-1]){
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }


}
