package Character.无重复字符串的最长子串;
public class Solution {
    public static void main(String[] args) {
        int i =lengthOfLongestSubstring("abcdeer");
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null&&s=="")
            return 0;
        char [] chars = s.toCharArray();
        char[] chars1=new char[chars.length];
        int max=0;
        int m=0;    //用来标识比较字符初始位置的下标
        for(int i=0;i<chars.length;i++){
            if(i==0){
                chars1[i]=chars[i];
            }
            else{
                for(int j=m;j<i;j++){
                    if(chars1[j]==chars[i]){
                        if(max<=i-m){
                            max=i-m;
                        }
                        m=j+1;
                        break;
                    }
                }
                chars1[i]=chars[i];
            }
        }
        if(max==0){
            max=chars.length;
            return max;
        }else{
            if(max<chars.length-m){
                max=chars.length-m;
                return max;
            }
            else
                return max;

        }

    }
}
