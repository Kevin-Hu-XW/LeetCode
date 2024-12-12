package 贪心;

import sun.security.provider.Sun;

import java.util.PriorityQueue;

/*
    一块金条切成两半，是需要花费和长度数值一样的铜板的。比如
    长度为20的 金条，不管切成长度多大的两半，都要花费20个铜
    板。一群人想整分整块金 条，怎么分最省铜板？
    给定数组{10,20,30}，代表一共三个人，整块金条长度为
    10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长
    度60的金条分成10和50，花费60 再把长度50的金条分成20和30，
    花费50 一共花费110铜板。
 */
public class LessMoney {
    //优先队列的作用是能保证每次取出的元素都是队列中权值最小的
    public int less(int[] arr) {
        //系统实现的堆，每次取出的都是权值最小值
        PriorityQueue<Integer> PQ =new PriorityQueue<>();
        //元素依次入堆
        for (int a:arr)
            PQ.add(a);
        int sum = 0;
        int cur = 0;
        while (PQ.size()>1) {
            cur = PQ.poll()+PQ.poll();
            //每次从堆中取出两个最小值
            sum = sum + cur;
            //新的元素入堆
            PQ.add(cur);
        }
        return sum;
    }
}
