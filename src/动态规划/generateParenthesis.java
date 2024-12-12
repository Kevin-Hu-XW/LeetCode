package 动态规划;

import java.util.ArrayList;
import java.util.List;
/*
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n==1){
            list.add("()");
            return list;
        }

        return null;
    }
}
