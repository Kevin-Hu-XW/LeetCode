package Array;

import java.util.HashMap;
import java.util.Map;
/*
    HashMap key存储nums[i]  value 存储下标i
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==0||nums.length==1)
            return new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){

            int temp = target - nums[i];  //

            if(map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
