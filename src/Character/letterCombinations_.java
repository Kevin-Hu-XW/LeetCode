package Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    思路：
 */
public class letterCombinations_ {
    public static List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0)
            return new ArrayList<String>();
        List<String> list = new ArrayList<>();
        list.add("");
        //数字与字符进行映射
        Map<Character,String> map =new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        int length = digits.length();
        for (int i=0;i<length;i++){
            int size = list.size();  //记录当前列表的长度
            String str = map.get(digits.charAt(i));  //遍历到第几个字符
            //取出当前列表的元素
            for (int j=0;j<size;j++){
                String tmp = list.remove(0);
                for (int k=0;k<str.length();k++){
                    //将字符与当前字符合并并添加到列表中
                    list.add(tmp+str.charAt(k));
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }
}
