package Array;
/*
    双指针法：从数组边界开始计算，因为需要两个指针的最小值*指针之间的距离来获得面积，
             直到指针相遇
 */

public class maxArea_ {
    public int maxArea(int[] height) {
        if(height==null)
            return 0;
        int p=0,q=height.length-1;
        int res=0,temp=0;
        while (p<q){
            temp = Math.min(height[p],height[q])*(q-p);
            res = Math.max(temp,res);
            if (height[p]<height[q]){
                p++;
            }
            else{
                q--;
            }
        }
        return res;
    }
}
