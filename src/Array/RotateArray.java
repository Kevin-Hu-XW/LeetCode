package Array;
/*
    类型题：旋转链表

 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if (nums==null)
            return;
        int length = nums.length;
        if (k%length==0)
            return;
        //计算出移动元素的开始下标和结束下标

        int start = length-(k%length);
        int end = nums.length-1;
        int[] res = new int[nums.length];
        int count=0;
        for (int i=start;i<nums.length;i++){
            res[count++] = nums[i];
        }
        for (int j=0;j<start;j++){
            res[count++] = nums[j];
        }
        System.arraycopy(res, 0, nums, 0, length);
        for (int i:nums){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] num={1,2,3,4,5,6,7};
        rotate(num,3);
    }
}
