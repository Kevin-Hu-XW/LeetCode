package 贪心;

public class maxProfit {
    public static boolean maxProfit(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i+nums[i]>=nums.length-1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(maxProfit(nums));
    }
}
