package Sort.插入排序;

public class Sort
{
    public static void main(String[] args) {
        int[] arr={108,11,6,10,11};
        insertSort(arr);
        System.out.println(arr[0]);
    }
    public static void insertSort(int[] arr){
        if(arr==null||arr.length<2)
            return;
        //插入排序，第一个数已经排好序，直接从第二个数开始
        for(int i=1;i<arr.length;i++){
            //j,j+1,不是j与i进行比较
            for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
