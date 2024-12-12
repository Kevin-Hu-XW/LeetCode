package StackAndQueue;

import java.util.Stack;

public class removeDuplicates {
    public static String removeDuplicates(String s) {
        if(s==null||s.length()==1) return s;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty()&&stack.peek()==ch){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        String str = "";
        while(!stack.isEmpty()){
            str =stack.pop() + str;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
