package 递归;
/*
    打印字符串所有子序
 */
public class Print_All_Subsquences {
    public void printAllSub(char[] str,int i,String res) {
        if (i==str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str,i+1,res);
        printAllSub(str,i+1,res+String.valueOf(str[i]));
    }
}
