package StackAndQueue;

import java.util.Stack;

public class GetMinStack {
    public static class MyStack1{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMinData;
        public MyStack1(){
            this.stackData=new Stack<Integer>();
            this.stackMinData=new Stack<Integer>();
        }
        //压栈
        public void push(Integer obj) {
            if (this.stackMinData.isEmpty()) {
                this.stackMinData.push(obj);
            }
            else{
                //压栈元素与栈顶元素比较，若小于栈顶元素，则压入stackMinData中，否则重新压入stackData.peek()元素
                if (obj<this.getmin()){
                    this.stackMinData.push(obj);
                }else {
                    this.stackMinData.push(this.stackData.peek());
                }
            }
            this.stackData.push(obj);
        }
        //出栈
        public Integer pop() {
            if (this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            int value=stackData.pop();
            if (value==stackMinData.peek()) {
                stackMinData.pop();
            }
            return value;
        }
        //GetMinData返回stackMinData中的最小值
        public Integer getmin() {
            if (!this.stackMinData.isEmpty()){
                return this.stackMinData.peek();
            }
            return null;
        }

    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getmin());

        stack1.push(4);
        System.out.println(stack1.getmin());

        stack1.push(1);
        System.out.println(stack1.getmin());

        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());
    }

}
