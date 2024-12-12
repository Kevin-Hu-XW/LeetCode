package Character;

import java.util.HashMap;
/*
    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    在第一次遍历时，我们使用哈希映射统计出字符串中每个字符出现的次数。在第二次遍历时，
    我们只要遍历到了一个只出现一次的字符，那么就返回该字符，否则在遍历结束后返回空格。
 */
public class firstUniqChar {
    public char firstUniqChar(String s) {
        if(s==null)
            return " ".toCharArray()[0];
        HashMap<Character,Integer> map  =new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }
            else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        for (int i=0;i<s.length();i++){
            if (map.get(s.charAt(i))==1)
                return s.charAt(i);
        }
        return ' ';
    }
}
