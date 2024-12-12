package StackAndQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
    用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> helper;
    public MyQueue(){
        stack = new Stack<>();
        helper = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> temp;
        while (!stack.isEmpty()){
            helper.push(stack.pop());
        }
        Integer value = helper.pop();
        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return value;
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> temp;
        while (!stack.isEmpty()){
            helper.push(stack.pop());
        }
        Integer value = helper.peek();
        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return value;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack.isEmpty())
            return true;
        return false;
    }
}
class MyStack{
    private Queue<Integer> queue;
    private Queue<Integer> helper;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        helper = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> temp;
        while (queue.size()>1){
            helper.offer(queue.poll());
        }
        Integer value = queue.poll();
        temp = helper;
        helper =  queue;
        queue = temp;
        return value;
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> temp;
        while (queue.size()>1){
            helper.offer(queue.poll());
        }
        Integer value = queue.peek();
        helper.offer(queue.poll());
        temp = helper;
        helper =  queue;
        queue = temp;
        return value;
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty()==true?true:false;
    }
}