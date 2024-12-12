package Array;
import java.util.ArrayList;
import java.util.List;
/*
    当前位 = (A 的当前位 + B 的当前位 + 进位carry) % 10
    注意，AB两数都加完后，最后判断一下进位 carry, 进位不为 0 的话加在前面。
    重要方法：
    list.add(0,sum);    //重要方法往首部添加元素,头插法
 */
public class AddToArrayForm_ {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
            int sum =0;
            int carry=0; //进位
            int i=num.length-1;
            while (i>=0||k!=0){  //两个条件有一个满足，循环就继续进行
                int x= i>=0?num[i]:0;
                int y= k!=0?k%10:0;
                sum = x+y+carry;
                carry= sum/10;
                sum = sum%10;
                list.add(0,sum);    //重要方法往首部添加元素
                k=k/10;
                i--;
        }
        //如果循环结束，进位不为0，则往list头部添加一位
        if (carry!=0){
            list.add(0,carry);
        }
        return list;
    }
}
