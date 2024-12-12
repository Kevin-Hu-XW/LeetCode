package Character;
/*
    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
    重点：num1.charAt(i)-'0'将每个字符转换为整数
          StringBuilder：可变的字符串，线程不安全的
          两数相加的方法，需要变量来表示是否进位
 */
@SuppressWarnings("all")
public class addStrings_ {
    public String addStrings(String num1, String num2) {
        int i =num1.length()-1,j=num2.length()-1;
        int add = 0;  //进位
        StringBuilder res = new StringBuilder();
        while (i>=0||j>=0||add!=0){
            int x = i>=0?num1.charAt(i)-'0':0;
            int y = j>=0?num2.charAt(j)-'0':0;
            int resault =x+y+add;
            res.append(resault%10);
            add = resault/10;
            i--;
            j--;
            String s =new String();
            int i1 =s.toCharArray().length;
        }
        res.reverse();
        return res.toString();
    }
}
