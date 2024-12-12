package 动态规划;
/*
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
    思路:爬到n级台阶，只能从n-1或则n-2级台阶爬上来，所以设f(n)为爬到n级台阶的总方案数，
         则有f(n)=f(n-1)+f(n-2)状态转移方程,边界条件f(0)=1,f(1)=1,f(2)=2,
         通过循环迭代计算出f(n)
 */
public class climbStairs {
    public int climbStairs(int n) {
        int a=0,b=0,res=1;
        for (int i=1;i<=n;i++){
            a = b;
            b = res;
            res = a+b;
        }
        return res;
    }

}
