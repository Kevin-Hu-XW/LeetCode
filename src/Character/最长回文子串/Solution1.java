package Character.最长回文子串;


public class Solution1 {
    public static void main(String[] args) {
        String s="sadas";
        String str= longestPalindrome(s);
        System.out.println(str);
    }

    public static String longestPalindrome (String s){
        int len = s.length();
        if (len < 2) {
            return s;
        }
        //初始化空字符串，用来存放longestStr
        String s1 = "";
        int max=0;
        //列举所有字符串进行判断
        for (int i=0;i<len;i++) {
            for(int j=i+1;j<=len;j++) {
                //获得每一组字符串
                String str = s.substring(i,j);
                if(isPalindromic(str)&&str.length()>max){
                    max=str.length();
                    s1=str;
                }
            }
        }
        return s1;
    }
    /*
       验证子串是否为回文子串
     */
    public static boolean isPalindromic(String s){
        int i=0;
        int j=s.length()-1;
        while(i<s.length()/2) {
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
