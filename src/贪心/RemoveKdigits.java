package 贪心;

import java.util.PriorityQueue;

/*
    找K次，每次找出当前的最小值
    String转char数组：str.toCharArray()
    char数组转String：String.valueOf(chars)
 */
public class RemoveKdigits {

    public static String removeKdigits1(String num, int k) {
        String str = num;
        char[] chars =  str.toCharArray();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i=0;i<k;i++){
            for (int j=0;j<chars.length;j++){
                queue.offer(deleteChar(str,j));
            }
            str = String.valueOf(queue.poll());
            chars = str.toCharArray();
        }

        return str;
    }
    public static long deleteChar(String string, int j){
        Long num;
        String deleteString = "";
        for(int i=0;i<string.length();i++){
            if (i!=j){
                deleteString += string.charAt(i);
            }
        }
        num = Long.parseUnsignedLong(deleteString);
        return num;
    }

    public static void main(String[] args) {
        String num = "1432219";
        num = removeKdigits1(num,3);
        System.out.println(num);
    }

}
