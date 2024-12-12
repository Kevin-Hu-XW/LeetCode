package Sort.bubblesort;

public class Sort
{
    public static void main(String[] args) {
        int[] arr={108,5,6,10,11};
        bubbleSort(arr);
        System.out.println(arr[0]);
    }
    public static void bubbleSort(int[] arr){
        if(arr==null||arr.length<2)
            return;
        for(int end=arr.length-1;end>0;end--){    //end!=0
            for(int i=0;i<end;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
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
