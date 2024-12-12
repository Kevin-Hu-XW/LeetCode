package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class calculate {
    public static int calculate(String s) {
        if(s==null) return 0;
        Deque<Integer> ops = new LinkedList<>();
        int ret = 0;
        int sign = 1;
        ops.push(1);
        int i=0;
        int n = s.length();
        while(i<n){
            char ch = s.charAt(i);
            if(ch==' '){
                i++;
            }
            else if(ch=='+'){
                sign = ops.peek();
                i++;
            }else if(ch=='-'){
                sign = -ops.peek();
                i++;
            }else if(ch=='('){
                ops.push(sign);
                i++;
            }else if(ch==')'){
                ops.pop();
                i++;
            }else{
                long num = 0;
                while(i<n&&Character.isDigit(s.charAt(i))){  //可能不是一位数，可能是多位数
                    num = num*10+(s.charAt(i)-'0');
                    i++;
                }
                ret += sign*num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
    }
}
