package Array;

import java.util.HashMap;
/*
    统计四数之和的个数：通过使用hash表，先统计两个数组之和，在统计另外两个数组之和
 */
public class fourSumCount {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if(nums1.length==0)
            return 0;
        if(nums1.length==1){
            if(nums1[0]+nums2[0]+nums3[0]+nums4[0]==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        int res = 0;
        HashMap<Integer,Integer> sumAB = new HashMap<>();
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                int target = nums1[i]+nums2[j];
                if (sumAB.containsKey(target)){
                    sumAB.put(target,sumAB.get(nums1[i]+nums2[j])+1);
                }
                else {
                    sumAB.put(target,1);
                }

            }
        }
        for (int i=0;i<nums3.length;i++){
            for (int j=0;j<nums4.length;j++){
                int target = -(nums3[i]+nums4[j]);   //通过取反来统计个数
                if (sumAB.containsKey(target)){
                    res += sumAB.get(target);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1={1,2}; int[] nums2={-2,-1}; int[] nums3={-1,2}; int[] nums4 ={0,2};
        int res = fourSumCount(nums1,nums2,nums3,nums4);
        HashMap<Integer,Integer> sumAB = new HashMap<>();
        System.out.println(sumAB.get(0));
    }
}
