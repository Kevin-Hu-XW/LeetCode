package StackAndQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {
    public static class TwoStackQueue{
        public Stack<Integer> stackpush;
        public Stack<Integer> stackpop;
        public TwoStackQueue(){
            stackpush=new Stack<Integer>();
            stackpop=new Stack<Integer>();
        }
        public void push(Integer obj) {
            stackpush.push(obj);
        }
        public Integer poll() {
            if (stackpop.empty()) {
                throw new RuntimeException("The queue is empty");
            }
            //若两个栈都为空，则抛异常
            if (stackpop.empty() && stackpush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackpop.isEmpty()) {
                while (!stackpush.empty()) {
                    stackpop.push(stackpush.pop());
                }
            }
            return stackpop.pop();

        }
        public Integer peek() {
            if (stackpop.empty()&&stackpush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            else if (!stackpop.empty()) {
                stackpop.push(stackpush.pop());
            }
            return stackpop.peek();
        }
    }

    public static class TwoQueueStack{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack(){
            queue=new LinkedList<Integer>();
            help=new LinkedList<Integer>();
        }
        //push
        public void push(Integer obj) {
            queue.add(obj);
        }
        //pop
        public Integer pop() {
            if (queue.isEmpty()){
                throw new RuntimeException("stack is empty!");
            }
            while (queue.size()>1) {
                help.add(queue.poll());
            }
            Integer value=queue.poll();
            Queue<Integer> tmp;
            tmp=help;
            help=queue;
            queue=tmp;
            return value;
        }
    }
}
