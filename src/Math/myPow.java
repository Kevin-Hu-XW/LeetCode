package Math;
/*
     Pow(x, n)
     思路：快速幂 + 递归
     n为偶数 myPow(double x, int n/2)*myPow(double x, int n/2)
     n为奇数 myPow(double x, int n/2)*myPow(double x, int n/2)*x
 */
public class myPow{
    public double myPow(double x, int n) {
        return n>0?quickPow(x,n):1/quickPow(x,-n);
    }
    public double quickPow(double x, int n){
        if (n==0)
            return 1;
        double y = quickPow(x,n/2);
        return n%2==0?y*y:y*y*x;
    }
}
