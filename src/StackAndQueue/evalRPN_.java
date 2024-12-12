package StackAndQueue;

import java.util.Stack;

/*
    有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    思路：遇到数字就进栈，遇到运算符号就连续出栈两个数，并把计算结果保留在temp中，在进行
         下一次运算
    通过switch进行判断运算符号
 */
public class evalRPN_ {
    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        Stack<Integer> stack  = new Stack<>();
        for (int i=0;i<length;i++){
            if (isNumber(tokens[i]))
                //若为数字，则进栈
                stack.push(Integer.parseInt(tokens[i]));
            else {
                String opt = tokens[i]
;                //若不为数字，则连续出栈两个元素
                int num1 = stack.pop();
                int num2 = stack.pop();
                int temp;
                switch (opt){
                    case("+"):
                        temp = num2+num1;
                        stack.push(temp);
                        break;
                    case("-"):
                        temp = num2-num1;
                        stack.push(temp);
                        break;
                    case("*"):
                        temp = num2*num1;
                        stack.push(temp);
                        break;
                    default:
                        temp = num2/num1;
                        stack.push(temp);
                        break;
                }
            }
        }
        return stack.pop();
    }
    //判断字符是否为数字
    public boolean isNumber(String str){
        return !(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"));
    }
}
