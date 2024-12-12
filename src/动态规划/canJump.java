package 动态规划;
/*
    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标。

 */
public class canJump {
    public static boolean canJump(int[] nums) {
            if (nums[0]==0&&nums.length!=1)
                return false;
            if (nums[0]==0&&nums.length==1)
                return true;
            int length = nums.length-1;
            int remoteMax = 0;
            for (int i=0;i<nums.length-1;i++){
                if (i+nums[i]>remoteMax){
                    remoteMax = i+nums[i];
                }
                if(remoteMax==i)
                    return false;
                if (remoteMax>=length)
                    return true;
            }
            if (remoteMax<length)
                return false;
            return true;

    }

    public static void main(String[] args) {
        int[] nums={1,0,1,0};
        boolean res = canJump(nums);
        System.out.println(res);
    }
}
