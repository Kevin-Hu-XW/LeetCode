package Array;
import java.util.Arrays;

public class findKMax {
    public int findKthLargest(int[] nums, int k) {
        if (nums==null)
            throw new RuntimeException("the array is null!");
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
