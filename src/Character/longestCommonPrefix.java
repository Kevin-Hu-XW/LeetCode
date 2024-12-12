package Character;
import java.util.HashMap;
import java.util.Map;

/*
    编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
    思路：

 */
public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        StringBuilder res = new StringBuilder("");
        Map<String,String> map =new HashMap<>();
        int minlength=Integer.MAX_VALUE;
        //计算出前缀长度最小的字符串
        for (int i=0;i<strs.length;i++){
            if (strs[i].length()<minlength)
                minlength = strs[i].length();
        }
        for (int k=0;k<minlength;k++){
            map = new HashMap<>();
            //遍历每个字符串观察是否存在相同的元素
            for (int i=0;i<strs.length;i++){
                if (map.size()==0){
                    map.put(String.valueOf(strs[i].charAt(k)),String.valueOf(strs[i].charAt(k)));
                }
                if (map.get(String.valueOf(strs[i].charAt(k)))==null){
                    return res.toString();
                }
            }
            //如果所有的字符串都存在相同的元素，即添加次元素到res中
            res.append(strs[0].charAt(k));
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String str = longestCommonPrefix(strs);
        System.out.println(str);
    }
}
