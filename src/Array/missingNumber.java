package Array;

import java.util.Arrays;

public class missingNumber {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
            if (i<nums.length){
                if(i!=nums[i])
                    return i;

            }
            else {
                return nums.length;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={3,1,0};
        int a = missingNumber(nums);
        System.out.println(a);
    }

}
