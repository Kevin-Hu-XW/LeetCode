package 回溯算法;


import java.util.*;

/*
    输入一个字符串，打印出该字符串中字符的所有排列。
    你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

    new ArrayList<>(new HashSet<String>(strs));  //列表去重复元素
    Deque<String> str = new ArrayDeque<>();
    str.removeLast();
 */
public class permutation {
    List<String> strs = new ArrayList<>();
    Deque<String> str = new ArrayDeque<>();
    StringBuilder temp = new StringBuilder();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];
        backtracking(chars,chars.length,used);
        strs =new ArrayList<>(new HashSet<String>(strs));  //列表去重复元素
        String[] strings = new String[strs.size()];
        int i=0;
        for (String s1:strs){
            strings[i++] =s1;
        }

        return strings;
    }
    public void backtracking(char[] chars, int len,boolean[] used){
        if (str.size()==len){
            for (String s:str){
                temp.append(s);
            }
            strs.add(temp.toString());
            temp = new StringBuilder();
            return;
        }
        for (int i=0;i<len;i++){
            if (!used[i]){
                str.add(String.valueOf(chars[i]));
                used[i] = true;
                backtracking(chars,len,used);
                used[i] = false;
                str.removeLast();
            }

        }

    }
}
