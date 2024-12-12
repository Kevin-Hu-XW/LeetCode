package StackAndQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    思路：若长度为奇数，直接返回false，遍历字符串，如果是左括号，则直接入栈，如果是右括号，则栈中元素出栈，并且判断是否匹配，若不匹配直接返回false；
         最后判断栈是否为空，若为空返回true，否则返回false；
 */
public class isValid_ {
    public boolean isValid(String s) {
        if (s==null)
            return true;
        int length = s.length();
        //若长度为奇数则一定为无效的括号
        if (length%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        //构建一个Map作为左右括号的映射
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        for (int i=0;i<length;i++){
            if (s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty())
                    return false;
                else {
                    char c = stack.pop();
                    //判断左括号是否与右括号对应
                    if (c==map.get(s.charAt(i)))
                        continue;
                    else
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
