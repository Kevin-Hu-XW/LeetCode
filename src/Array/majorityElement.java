package Array;
import java.util.Arrays;
public class majorityElement {
    public static int majorityElement(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int len = nums.length/2;
        Arrays.sort(nums);
        int count = 1;
        int i;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                count++;
                if(count>len){
                    break;
                }

            }else{
                count = 1;
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,2,2,2,5,4,2};
        int a = majorityElement(nums);
        System.out.println(a);
    }
}
