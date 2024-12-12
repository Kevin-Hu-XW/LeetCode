package 动态规划;
/*
    在一个回文串中，只有最多一个字符出现了奇数次，其余的字符都出现偶数次。
 */
public class longestPalindrome_int_ {
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            count[c]++;
        }
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int v:count){
            res += v/2*2;
            //之后只需计算一次
            if (v%2==1&&res%2==0)
                res++;
        }
       return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
