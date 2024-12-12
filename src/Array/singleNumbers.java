package Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
    一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
    请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

    利用HashMap中key的不可重复性进行实现
 */
public class singleNumbers {
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (map.get(nums[i])!=null){
                map.remove(nums[i]);
                continue;
            }

            map.put(nums[i],nums[i]);

        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer:map.values()){
            list.add(integer);
        }
        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
