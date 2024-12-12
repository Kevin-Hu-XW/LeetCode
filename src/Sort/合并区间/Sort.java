package Sort.合并区间;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[][] arrs={{1,3},{2,6},{8,10},{15,18}};
        arrs=merge(arrs);
        for (int[] arr:arrs){
            System.out.println(arr[0]);
        }
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length==0) {
            return  new int[0][2];
        }
        int[][] res=new int[intervals.length][2];
        //标识结果数组是否为空数组
        int id=-1;
        //重写array.sort()比较器,按照起始位置排序，方便后续的合并区间操作
        int times=0;
        Arrays.sort(intervals,(v1,v2) -> v1 [0]-v2[0]);
        for (int i=0;i<intervals.length;i++) {
            //不合并，直接放入数组中
            if (id==-1||res[id][1]<intervals[i][0]){
                res[++id]=intervals[i];
            }
            else{
                //合并
                res[id][1]=Math.max(res[id][1],intervals[i][1]);
                //统计合并次数
                times++;
            }
        }
        return Arrays.copyOf(res,intervals.length-times);
    }
}
