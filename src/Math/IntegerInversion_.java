package Math;
/*
    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 */
public class IntegerInversion_ {
    public int reverse(int x) {
        int res=0,digit=0;
        while (x!=0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10)
                return 0;
            digit = x%10;
            res = res*10+digit;
            x = x/10;
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
