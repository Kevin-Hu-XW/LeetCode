package 动态规划;
/*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    思路：只需要求出每个位置的 f(i)，然后返回其中的最大值即可
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length==1)
            return nums[0];
        int res = 0,maxRes=nums[0];
        for (int i=0;i<nums.length;i++){
            res = Math.max(res+nums[i],nums[i]);  //求数组中的i之前数组的最大值
            maxRes = Math.max(maxRes,res);  //保存遍历过程中的i之前连续数组的最大值
        }
        return maxRes;
    }
}
