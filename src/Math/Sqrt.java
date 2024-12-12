package Math;
/*
    实现 int sqrt(int x) 函数。
    计算并返回 x 的平方根，其中 x 是非负整数。
    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Sqrt {
    public int mySqrt1(int x) {
        if (x==0)
            return 0;
        int ans = (int)Math.exp(0.5*Math.log(x));
        ans = (ans+1)*(ans+1)<=x?ans+1:ans;
        return ans;
    }

    /*
        二分法: 二分搜索用于在一个单调或者局部单调有序数组中查找一个符合某些条件的值，时间复杂度为O(logN)
        mid =l+(r-l)/2，中位数求法防止溢出
     */
    public int mySqrt(int x) {
        if (x==0)
            return 0;
        int l=0;
        int r=x;
        int mid,ans=0;
        while (l<=r) {
            mid =l+(r-l)/2;
            if ((long)mid*mid<=x){
                ans=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return ans;
    }
}
