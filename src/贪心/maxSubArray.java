package 贪心;

public class maxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length==1)
            return nums[0];
        int res = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count = 0;
            for(int j=i;j<nums.length;j++){
                count += nums[j];
                res = res>count?res:count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
