package Array;

import java.util.HashMap;


public class singleNumberII {
    static int res;
    public static int singleNumber(int[] nums) {
        if (nums.length==1)
            return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.get(nums[i])!=null){
                map1.put(nums[i],nums[i]);
                continue;
            }
            map.put(nums[i],nums[i]);
        }
        for (Integer integer:map1.values()){
            map.remove(integer);
        }
        for (Integer integer:map.values())
            res = integer;
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,1,6,1};
        int res = singleNumber(nums);
        System.out.println(res);
    }
}
