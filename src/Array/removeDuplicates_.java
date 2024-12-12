package Array;
/*
    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
    使每个元素 只出现一次 ，返回删除后数组的新长度。
    不要使用额外的数组空间,你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
    思路：数组中删除重复的元素，实际上就是把重复的元素移动重复元素的左边
    使用两个指针i和j,i表示快指针，j表示慢指针
 */
public class removeDuplicates_ {
    public int removeDuplicates(int[] nums) {
        if (nums.length<2)
            return nums.length;
        int j=0;
        for (int i=1;i<nums.length;i++) {
            if (nums[j]!=nums[i])
                nums[++j] = nums[i];
        }
        return  j+1;
    }
}
