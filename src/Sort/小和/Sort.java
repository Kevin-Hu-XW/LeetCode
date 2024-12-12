package Sort.小和;

public class Sort
{
    public static void main(String[] args) {
        int[] arr={1,3,4,2,5};
        int res= smallSum(arr);
        System.out.println(res);

    }
    public static int smallSum(int[] arr){
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
        //创建额外的数组空间，存放需要归并的数组
        int[] help=new int[R-L+1];
        int i=0;
        int res=0;
        while (p1<=mid&&p2<=R){

            //计算小和
            res+=arr[p1]<arr[p2]?(R-p2+1)*arr[p1]:0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        //把排好序的数组赋值给arr
        for(int k=0;k<help.length;k++){
            arr[L+k]=help[k];
        }
        return res;
    }
}
