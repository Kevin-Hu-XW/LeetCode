package Character;
/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
方法一：HashMap<Character,Integer> maps = new HashMap<Character,Integer>();
        记录每个字母的个数，然后比较两个map中相同字母个数是否相同
方法二：对字符串进行排序

 */
import java.util.Arrays;
import java.util.HashMap;

public class isAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }
}
