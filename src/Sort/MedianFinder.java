package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
    一个数据流中，随时可以取得中位数
 */
public class MedianFinder {
    /*
       maxHeap保存数据较小的一半，minHeap保存数据较大的一半
       maxHeap长度为 N/2,(N为偶数)或(N+1)/2，N为奇数
       minHeap长度为 N/2,(N为偶数)或(N-1)/2，N为奇数
      */
    PriorityQueue<Integer> maxHeap ;
    PriorityQueue<Integer> minHeap ;
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<Integer>(new MaxComparator());
        this.minHeap = new PriorityQueue<Integer>(new MinComparator());
    }
    public void addNum(int num) {
        if (maxHeap.size()!=minHeap.size()){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else {
            /*
                maxHeap.size()==minHeap.size()时，为了使奇数时可以从maxHeap中获得中位数，
                所以要往maxHeap中插入元素，因为MaxHeap中保存的是较小的一部分，所以要先入minHeap堆，
                前半部分整体的最小值，在入maxHeap
             */
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }
    /*
        若为奇数，则从maxHeap中弹出，偶数则取两个堆顶的平均值
     */
    public double findMedian() {
        return maxHeap.size()!=minHeap.size()?maxHeap.peek():(maxHeap.peek()+minHeap.peek())/2.0;
    }
    public class  MaxComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
    public class MinComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
}
