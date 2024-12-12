package HashMap;

import java.util.HashSet;
/*
    方法一：
    利用HashSet
    方法二：
    在对数字从小到大排序之后，数组的重复元素一定出现在相邻位置中。
    因此，我们可以扫描已排序的数组，每次判断相邻的两个元素是否相等，
    如果相等则说明存在重复的元素。
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums==null||nums.length==0)
            return false;
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i:nums){
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}
