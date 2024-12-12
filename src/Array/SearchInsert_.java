package Array;
/*
    求中点位置下标方法：int mid = l+(r-l)/2;
 */
public class SearchInsert_ {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length-1;
        int l=0,r=length;
        int index= 0;
        while (l<=r){
            int mid = l+(r-l)/2;    //r-l不是r-1，右边界减左边界
            if (nums[mid]==target){
                return mid;
            }
            else if (nums[mid]>target){
                // 目标值小于mid所指向的值，则right=mid-1
                // 原因是[left,right]内的元素时待考察的元素
                r=mid-1;
            }
            else if (nums[mid]<target){
                // 同样的目标值大于mid所指向的值，则left=mid+1
                // 由于mid整个位置已考察
                l=mid+1;
            }
        }
        return l;
    }
}
