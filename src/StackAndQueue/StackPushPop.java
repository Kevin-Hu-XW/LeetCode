package StackAndQueue;

import java.util.Stack;
public class StackPushPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack1=new Stack<Integer>();
        int j=0;
        for (int i=0;i<pushed.length;i++) {
            stack1.push(pushed[i]);
            while (!stack1.isEmpty()&&stack1.peek()==popped[j]) {
                stack1.pop();
                j++;
            }
        }
        return stack1.isEmpty();
    }
}
