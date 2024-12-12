package Array.寻找两个正序数组的中位数;

public class Solution {
    public static void main(String[] args) {
        int[] nums1={1,6,9};
        int[] nums2={3,5,8};
        double mid= findMedianSortedArrays(nums1,nums2);
        System.out.println(mid);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int m=nums1.length;
        int n=nums2.length;
        int[] nums=new int[m+n];
        if(m+n==1){
            if(m==1)
                return nums1[0];
            else
                return nums2[0];
        }
        /*
            按升序的方式，合并两个数组
        */
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                nums[k]=nums1[i];
                i++;
            }
            else{
                nums[k]=nums2[j];
                j++;
            }
            k++;
        }
        if(i>=m){
            while(j<n) {
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        if(j>=n){
            while(i<m){
                nums[k]=nums1[i];
                i++;
                k++;
            }
        }
        /*
            取合并后数组的中位数
            Math.floor(index)  ---向下取整
            Math。ceil（index）---向上取整
         */
        if(nums.length%2!=0){
            double index=nums.length/2;
            index =Math.floor(index);
            int Index=(int)index;
            return  nums[Index];
        }
        else{
             double mid=(double)(nums[nums.length/2]+nums[nums.length/2-1])/2;
             return mid;
        }

    }

}
