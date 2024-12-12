package Sort.逆序数;
//输出逆序数
public class Sort
{
    public static void main(String[] args) {
        int[] arr={2,4,3,5,1};
        int num= reverseParis(arr);
        System.out.println(num);

    }
    public static int reverseParis(int[] arr){
        if(arr==null||arr.length<2){
            return 0;
        }
        return sortProcess(arr,0,arr.length-1);
    }

    public static int sortProcess(int[] arr,int L,int R){
        //当只有一个数的时候排序终止
        if(L==R){
            return 0;
        }
        int mid=(L+R)/2;
        return sortProcess(arr,L,mid)+sortProcess(arr,mid+1,R)
                +merge(arr,L,R,mid);
    }
    public static int merge(int[] arr,int L,int R,int mid){
        int p1=L;
        int p2=mid+1;
        int i=0;
        int num=0;
        int[] help=new int[R-L+1];
        while (p1<=mid&&p2<=R) {
            num+=arr[p1]<=arr[p2]?0:(mid-p1+1);
            help[i++]=arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for (int k=0;k<help.length;k++){
            arr[L+k]=help[k];
        }
        return num;
    }
}
