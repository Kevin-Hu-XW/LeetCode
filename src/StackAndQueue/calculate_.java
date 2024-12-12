package StackAndQueue;
/*
    四则混合运算通用方法:
    nums:存放所有数字
    ops：存放数字以外的操作
    1、空格，直接跳过
    2、(：直接加入ops中，等待与之相匹配的)
    3、): 使用栈中的nums和ops进行计算，并把计算结果放入nums中，直到遇到')'为止
    4、数字：从当前位置往后取，可能是多位数，并加入nums中，直到遇到操作符为止
    5、+-*、：需要将操作符放入ops中，在放入之前先把栈内可以算的都算掉(只有当栈内运算符的优先级大于等于当前运算符的优先级，才可以进行)
             直到没有操作或者遇到左括号，将计算结果放入nums中
    技巧: 1、为了减少边界的判断，先往nums中加入0
         2、nums最好是long，防止溢出情况
         3、为防止()内出现的首个字符为运算符，将所有的空格去掉，并将(-替换为(0-，(+ 替换为(0+
 */

import java.util.*;

public class calculate_ {


    //定义计算规则
    public static void calc(Deque<Integer> nums,Deque<Character> ops ){
        if(nums.isEmpty()||nums.size()<2||ops.isEmpty()) return;
        int b = nums.pollLast(); int a = nums.pollLast();   //注意顺序，b先出栈，a出栈，a-b
        char op = ops.pollLast();
        int res = 0;
        if (op=='+') res = a+b;
        else if(op=='-') res = a-b;
        else if(op=='*') res = a*b;
        else if(op=='/') res = a/b;
        nums.addLast(res);
    }
    public static int calculate(String s) {
        //定义运算符优先级
        Map<Character,Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);

        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        //去掉空格
        s = s.replaceAll(" ","");
        int length = s.length();
        char[] chs = s.toCharArray();
        //为了防止第一个数为负数，先加个0
        nums.addLast(0);
        for (int i=0;i<length;i++){
            //如果是括号
            if (s.charAt(i)=='('){
                ops.addLast(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()){
                    if (ops.peekLast()=='('){
                        ops.pollLast();
                        break;
                    }else {
                        calc(nums,ops);  //不是)则进行
                    }
                }
            }
            //如果是数字
            else if (Character.isDigit(s.charAt(i))){
                int num = s.charAt(i)-'0';
                int j = i;
                j++;
                while (j<length&&Character.isDigit(s.charAt(j))){
                    num = num*10 + s.charAt(j)-'0';
                    j++;
                }
                nums.addLast(num);
                i = j-1; //最后一次执行完后for循环会进行一次++，防止多加一次
            }
            //如果是+-*/
            else{
                //为防止 () 内出现的首个字符为运算符，将所有的空格去掉，并将 (- 替换为 (0-，(+ 替换为 (0+
                if(i>0&&(s.charAt(i-1)=='('||s.charAt(i-1)=='+'||s.charAt(i-1)=='-'))
                    nums.addLast(0);
                // 有一个新操作要入栈时，先把栈内可以算的都算了
                // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                while (!ops.isEmpty()&&ops.peekLast()!='('){
                    if(map.get(ops.peekLast())>=map.get(s.charAt(i))){
                        calc(nums,ops);
                    }
                    else{
                        break;
                    }
                }
                ops.addLast(s.charAt(i));

            }
        }
        //将数组中的剩余元素算完
        while (!ops.isEmpty()){
            calc(nums, ops);
        }
        return nums.peekLast();
    }
    public static void main(String[] args) {
        String s="1-(-2)";
        System.out.println(calculate(s));
    }
}
