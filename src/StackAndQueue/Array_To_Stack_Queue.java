package StackAndQueue;

public class Array_To_Stack_Queue {
    public static  class ArrayStack {
        public static Integer[] arr;
        public static Integer index;

        public ArrayStack(Integer initSize) {
            if (initSize<0) {
                throw new IllegalArgumentException("the initSize is less than 0");
            }
            //初始化栈数组大小
            arr=new Integer[initSize];
            //初始化栈顶指针，表示新压入栈的数存放的位置
            index=0;
        }
        //返回栈顶元素
        public Integer peek() {
            if (index==0) {
                return null;
            }
            return arr[--index];
        }
        //压栈
        public void push(Integer obj) {
            if (index==arr.length) {
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[index++]=obj;
        }

        //出栈
        public Integer pop() {
            if (index==0) {
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--index];
        }
    }

    public static class ArrayQueue {
        public static Integer[] arr;
        public static Integer size;
        public static Integer start; //出队列元素的位置
        public static Integer end;   //进队列元素的位置

        public ArrayQueue(Integer initSize) {
            if (initSize==0) {
                 throw new IllegalArgumentException("The InitSize is less than 0");
            }
            arr=new Integer[initSize];
            size=0;
            start=0;
            end=0;
        }
        //返回栈顶元素
        public Integer peek() {
            if (size==0) {
                return null;
            }
            return arr[start];
        }
        //入队
        public void push(Integer obj) {
            if (size==arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[end]=obj;
            end=end==arr.length-1?0:end+1;
            size++;
        }
        //出队
        public Integer pop() {
            if (size==0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            int num=start;
            start=start==arr.length-1?0:start+1;
            size--;
            return arr[num];
        }
    }
}
