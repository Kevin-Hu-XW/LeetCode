package Sort.选择排序;

public class Sort
{
    public static void main(String[] args) {
        int[] arr={108,11,6,10,11};
        selectSort(arr);
        System.out.println(arr[0]);
    }
    public static void selectSort(int[] arr){
        if(arr==null||arr.length<2)
            return;
        //外面for循环规定开始规定开始与结束的位置
        int minindex=0;
        for(int i =0;i<arr.length;i++){
            //每一循环找出一个最小值，放到第i个位置
            minindex = i;
            for(int j=i;j<arr.length;j++){
                if(arr[minindex]>arr[j]){
                    minindex=j;
                }
            }
            swap(arr,i,minindex);
        }

    }
    public static void swap(int[] arr,int i,int j){
        int temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
