package Array;
import java.util.*;
/*
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    本题的暴力题解可以仿照二数之和，直接三层遍历，取和为0的三元组，并记录下来，最后再去重。
 */
public class threeNumbersSum_ {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length==0||nums.length==1&&nums[0]==0)
            return new ArrayList<>();
        if (nums.length>=3) {
            List<List<Integer>> list=new ArrayList<>();
            for (int i=0;i<nums.length;i++) {
                for (int j=i+1;j<nums.length;j++) {
                    for (int k=j+1;k<nums.length;k++) {
                        if (nums[i]+nums[j]+nums[k]==0) {
                            list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        }
                    }
                }
            }
            return removeDuplicate(list);
        }

        return new ArrayList<>();
    }
    public static List<List<Integer>> removeDuplicate(List<List<Integer>> list) {
        for (List<Integer> l:list) {
            //对列表的元素进行排序
            Collections.sort(l);
        }
        //删除列表重复元素
        HashSet hashSet =new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }





    //方法二：双指针
    /*
    可以先固定一个值，然后寻找后两个值时可采取双指针的方法，将总的时间复杂度优化到 O(n^2)。
    实现的过程中，要注意优化以及去重。首先我们先对原数组进行排序，这样可以把重复的值集中到一起，便于去重。
    确定第一个元素时，如果它已经比 0 大了，那么可以直接跳出循环，因为后面的数字都比它大。
    如 [1, 2, 3, 4], i = 0, nums[i] > 0, 这样是不可能产生合法的情况的，直接 break。
    确定第一个元素时，如果发现它与它前面的值一样，那么跳过本轮。如 [-1, -1, 0, 1],
    在第一轮后，已经选出了 {-1, 0, 1}, 现在 i = 1，nums[i] == nums[i - 1], 为了避免重复，直接 continue。
    接下来利用双指针，left 指向 i + 1, right 指向 nums.length - 1。逐个进行判断，并注意去重。
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length==0||nums.length<=2)
            return res;
        //对数组进行排序，方便后面去重
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue; //去重
            int target = 0-nums[i];
            int l = i+1;
            int r = nums.length-1;
            while (l<r) {   //l与r相遇时截止
                if (nums[l]+nums[r]==target) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r])));
                    ++l;--r;
                    while (l<r&&nums[l]==nums[l-1]) l++;
                    while (l<r&&nums[r]==nums[r+1]) r--;
                }
                else if (nums[l]+nums[r]>target){
                    r--;
                }
                else {
                    l++;
                }
            }
        }

        return res;
    }















    public static void main(String[] args) {
        int[] sum ={-1,0,1,2,-1,-4};
        List<List<Integer>> list =threeSum(sum);
        System.out.println(list);
    }
}
