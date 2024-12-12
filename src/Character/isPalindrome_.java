package Character;

import java.util.ArrayList;
import java.util.List;


/*
    双指针
    StringBuffer str = new StringBuffer()
    str.append(Character.toLowerCase(c))    添加字符到字符串中
    Character.isLetterOrDigit(c)   判断字符是字母或者是数字
    Character.toLowerCase(c)       把每个字符转为小写字母
    str.charAt(start)              获取字符串第start下标的字符
 */
public class isPalindrome_ {
    public static boolean isPalindrome(String s) {
        if (s=="")
            return true;
        StringBuffer str = new StringBuffer();
        //char[] str = s.toCharArray();
        //List<String> list = new ArrayList();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);  //获得字符串的第i个字符
            if (Character.isLetterOrDigit(c))
                str.append(Character.toLowerCase(c));
        }
        System.out.println(str);
        int start=0,end=str.length()-1;
        while (start<=end){
            if (str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "a.@#";
        boolean flag = isPalindrome(str);
        System.out.println(flag);
    }
}
