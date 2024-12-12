package StackAndQueue;
import java.util.Stack;
public class MinStack {
    public Stack<Integer> stackData;
    public Stack<Integer> stackMinData;
    /** initialize your data structure here. */
    public MinStack() {
        stackData=new Stack<Integer>();
        stackMinData=new Stack<Integer>();
    }

    public void push(int x) {
        if(stackMinData.empty()){
            stackMinData.push(x);
        }
        else{
            int value=stackMinData.peek();
            if(value<x){
                stackMinData.push(value);
            }else{
                stackMinData.push(x);
            }

        }
        stackData.push(x);
    }

    public void pop() {
        if(stackData.empty()){
            throw new RuntimeException("Your stack is empty.");
        }else{
            stackData.pop();
            stackMinData.pop();
        }
    }

    public int top() {
        if(!stackData.empty())
            return stackData.peek();
        throw new RuntimeException("Your stack is empty.");

    }

    public int min() {
        if(!stackData.empty())
            return stackMinData.peek();
        throw new RuntimeException("Your stack is empty.");

    }
}
