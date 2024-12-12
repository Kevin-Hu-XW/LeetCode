package Array;
/*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。
    找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回 [-1, -1]。
    暴力解法思路：因为数组是以排好序的，通过num来记录target的个数，直到nums[i]！=target退出循环，
                此时的下标减1，就是最后一位target的下标，即end=i-1,start=i-num
    实现时间复杂度为 O(log n):二分法
 */
public class searchRange_thrid {
    public static int[] searchRange1(int[] nums, int target) {
        if(nums==null)
            return new int[0];

        int start=0,end=0,num=0;
        int i;
        for (i=0;i<nums.length;i++) {
            while(i<nums.length&&nums[i]==target){
                num++;
                i++;
            }
            if (num>0){
                break;
            }

        }
        if (num==0){
            return new int[]{-1,-1};
        }
        end=i-1;
        start=i-num;
        int [] res={start,end};
        return res;
    }




    //实现时间复杂度为 O(log n):二分法
    public static int[] searchRange(int[] nums, int target) {
        return null;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        for(int i:searchRange(nums,8)){
            System.out.print(i);
        }
    }
}
