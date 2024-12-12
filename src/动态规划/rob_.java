package 动态规划;

@SuppressWarnings("all")
public class rob_ {
    //动态规划
    public int rob(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int i;
        for (i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
    //动态规划+滚动数组
    //因为只需存储最高的金额，而不需要存储整个数组的值
    public int rob1(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0],nums[1]);
        int temp;
        for (int i=2;i<nums.length;i++){
            temp = second;
            second = Math.max(second,first+nums[i]);
            first = temp;
        }
        return second;
    }
    /*
        你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ,
        这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
        如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     */
    public int rob_II(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(max(0,nums.length-2,nums),max(1,nums.length-1,nums));
    }
    public int max(int start,int end,int[] nums){
        int first = nums[start];
        int second = Math.max(nums[start],nums[start+1]);
        int temp;
        for (int i=start+2;i<=end;i++){
            temp = second;
            second = Math.max(second,first+nums[i]);
            first = temp;
        }
        return second;
    }

}
