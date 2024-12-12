package 动态规划;

import java.util.Arrays;

/*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    若新建长度为 n的dp列表，则空间复杂度为 O(N) 。


    由于 dp列表第 i项只与第 i-1 和第 i−2 项有关，因此只需要初始化三个整形变量 sum, a, b ，
    利用辅助变量 sum使 a,b 两数字交替前进即可 （具体实现见代码） 。
    因为节省了 dp列表空间，因此空间复杂度降至 O(1) 。
*/
public class numWays_ {
    public int numWays(int n) {

        int a=1,b=1,sum;
        for (int i=0;i<n;i++){
            sum = (a+b)% 1000000007;
            a = b;
            b = sum;
        }


        return a;
    }
}
