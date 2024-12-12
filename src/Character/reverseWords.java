package Character;
import java.util.Stack;
/*
    思路：字符分割
 */
public class reverseWords {
    public static String reverseWords(String s) {
        if (s==null)
            return null;
        String[] strs =s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder stringBuilder = new StringBuilder();
        //倒序进行添加数组
        for (int i=strs.length-1;i>=0;i--){     //倒序遍历单词列表
            if (strs[i].equals("")) continue;   //遇到空单词则跳过
            stringBuilder.append(strs[i]+" ");  //将单词拼接至 StringBuilder
        }
        return stringBuilder.toString().trim(); //转化为字符串，删除尾部空格，并返回
    }
    public static void main(String[] args) {
        String s = reverseWords("  hello world!  ");
        System.out.println(s);
    }
}