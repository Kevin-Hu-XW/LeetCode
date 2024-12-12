package Array;
/*
    给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
    假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
    你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
    思路：二分查找
 */
public class findDuplicate_ {
    public int findDuplicate(int[] nums) {
        if (nums.length==2)
            return nums[0];

        return 0;
    }
}
