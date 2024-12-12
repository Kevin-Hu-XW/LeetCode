package Array;

public class search {
    public int search(int[] nums, int target) {
        if (nums.length==0)
            return -1;
        if (nums.length==1&&target==nums[0]){
            return nums[0];
        }
        for (int i=0;i<nums.length;i++){
            if (target==nums[i]){
                return target;
            }
        }
        return -1;
    }
}
