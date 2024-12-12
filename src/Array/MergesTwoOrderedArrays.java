package Array;
/*
    给你两个有序整数数组nums1和nums2，
    请你将nums2合并到nums1中，使nums1成为一个有序数组。
    初始化nums1和nums2的元素数量分别为m和n.
    你可以假设nums1的空间大小等于m + n，
    这样它就有足够的空间保存来自 nums2 的元素。
     System.arraycopy(nums3, 0, nums1, 0, m+n);用于数组间的元素复制
 */
public class MergesTwoOrderedArrays {
    public static void  merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1==null&&nums2==null)
            throw new RuntimeException("the array is null");
        if (nums1==null&&nums2!=null){
            nums1=nums2;
            return ;
        }
        int i=0,j=0;
        int[] nums3=new int[m+n];
        int Count=0;
        while (i<m&&j<n){
            if (nums1[i]<=nums2[j]){
                nums3[Count++] = nums1[i++];
            }else {
                nums3[Count++] = nums2[j++];
            }
        }
        if (i!=m) {
            while (i<m){
                nums3[Count++] = nums1[i++];
            }
        }
        if (j!=n){
            while (j<n){
                nums3[Count++]=nums2[j++];
            }
        }
        System.arraycopy(nums3, 0, nums1, 0, m+n);
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
        for (int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }
}
