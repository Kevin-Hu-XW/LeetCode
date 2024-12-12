package Sort.归并排序;

public class Sort
{
    public static void main(String[] args) {
        int[] arr={108,5,6,10,11};
        mergeSort(arr);
        System.out.println(arr[4]);
    }
    public static void mergeSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        int L=0;
        int R=arr.length-1;
        sortProcess(arr,L,R);
    }
    public static void sortProcess(int[] arr,int L,int R){
        if(L==R){
            return ;
        }
        int mid=(L+R)/2;
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,R,mid);
    }
    public static void merge(int[] arr,int L,int R,int mid){
        int p1=L;
        int p2=mid+1;
        //创建额外的数组空间，存放需要归并的数组
        int[] help=new int[R-L+1];
        int i=0;
        while (p1<=mid&&p2<=R){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for(int k=0;k<help.length;k++){
            arr[L+k]=help[k];         //让排好序的数组把原数组覆盖
        }
    }
}
