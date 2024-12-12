package Sort.快排序;

public class Sort
{
    public static void main(String[] args) {
        int[] arr={108,11,6,10,11};
        if(arr==null||arr.length<2)
            return;
        int[] res=partition(arr,0,arr.length-1);
        quickSort(arr,0,arr.length-1);

        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quickSort(int[] arr,int L,int R){
        if (L<R){
            //任意选一个数与最后一个数交换，实现随机快排
            swap(arr,L+(int) Math.random()*(R-L+1),R);
            int[] res=partition(arr,L,R);
            quickSort(arr,L,res[0]-1);
            quickSort(arr,res[1]+1,R);
        }
    }
      //默认用最后一个数进行划分
    public static int[] partition(int[] arr,int L,int R){
        int less=L-1;
        int more=R;
        int cur=L;
        while (cur<more){
            if(arr[cur]<arr[R]){
                swap(arr,++less,cur++);
            }
            else if(arr[cur]>arr[R]){
                swap(arr,--more,cur);
            }
            else{
                cur++;
            }
        }
        //一次划分完成后，最后一个数与arr[more]交换
        swap(arr,more,R);
        return new int[]{less+1,more};
    }
    public static void swap(int[] arr,int i,int j){
        int temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
