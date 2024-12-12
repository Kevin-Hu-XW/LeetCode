package Array;

import java.util.Arrays;

public class threeSumClosest {
    int sum=0;
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3)
            return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {  //三数之和，固定一个数，利用双指针移动另外两个数
            int l = i + 1, r = nums.length - 1;
            sum = nums[i];
            while (l < r) {
                sum = sum + nums[l] + nums[r];
                if (target == sum) {    //结果若为零，直接返回
                    return sum;
                }
                if (Math.abs(target - sum) < Math.abs(target - ans)) {  // Math.abs 获取距离最近的值
                    ans = sum;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
                sum = nums[i];
            }
        }
        return ans;
    }
}
