package Sort.堆排序;
public class Sort
{
    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4};
        heapSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

}
    //堆排序
    public static void heapSort(int[] arr){
        if(arr==null||arr.length<2)
            return;
        //建立大根堆
        for (int i=0;i<arr.length;i++){
            heapinsert(arr,i);
        }
        //对大根堆进行堆排序
        int heapsize=arr.length;
        //将0位置上的元素与数组末尾元素交换，heapsize表示当前堆的元素个数
        swap(arr,0,--heapsize);
        while (heapsize>0){
            heapfiy(arr,0,heapsize);
            swap(arr,0,--heapsize);
        }
    }
    //把数组建立成一个大根堆
    public static void heapinsert(int[] arr,int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    //将0位置上的元素与数组末尾元素交换后，重新排序建立大根堆
    public static void heapfiy(int[] arr,int index,int heapsize){
        int left=index*2+1;  //表示index孩子节点的下标
        while (left<heapsize){ //当孩子节点下标越界后,说明子孩子不存在在，则比较结束
            int largest = (left+1<heapsize)&&arr[left+1]>arr[left]?left+1:left; //孩子节点中选出最大值的下标
            //孩子节点中的最大值与父节点比较，选出最大值下标进行交换
            largest=arr[index]>arr[largest]?index:largest;
            if (index==largest){
                break;
            }
            swap(arr,index,largest); //最大值与父节点交换
            index=largest;
            left=index*2+1;
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
