package Array;
/*
    给你一个输入数组 nums，找到峰值元素并返回其索引。
    数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 */
public class findPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length==1||nums.length==2&&nums[0]>nums[1]){
            return 0;
        }

        if (nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        int res = 0;
        for (int i=1;i<nums.length-1;i++){
            if (nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                res = i;
                break;
            }
        }
        return res;
    }
}
