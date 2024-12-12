package Sort.荷兰国旗问题;
/*
    给定一个数组arr，和一个数num，请把小于num的数放在数组的
    左边，等于num的数放在数组的中间，大于num的数放在数组的
    右边。
    要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class NeitherLandsFlag
{
    public static void main(String[] args) {
        int[] arr={8,8,11,6,10,11};
        int[] res=partition(arr,0,arr.length-1,8);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
    public static int [] partition(int[] arr,int L,int R,int num){
        //less为小于区域
        int less=L-1;
        //more为大于区域
        int more=R+1;
        int cur=L;
        while (cur<more){   //cur与more不相遇的情况下遍历下去
            if(arr[cur]<num){
                swap(arr,++less,cur++);
            }
            else if(arr[cur]==num){
                cur++;
            }
            else
            {
                swap(arr,--more,cur);
            }
        }
        //返回与num相等的数的下标
        return new int[]{less+1,more-1};
    }
    public static void swap(int[] arr,int i,int j){
        int temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
