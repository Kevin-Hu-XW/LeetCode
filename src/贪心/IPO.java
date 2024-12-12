package 贪心;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
    利用优先级队列，小根堆每次获取花费最小，且小于初始金额的项目加入大根堆，
    从大根堆中每次获取利润最大的项目，并完成项目，循环进行，直到完成K次项目，
    或者大根堆中没有可进行的项目停止
 */
public class IPO {
    public class Node{
        public int p; //利润
        public int c; //花费
        public Node(int p,int c) {
            this.p = p;
            this.c = c;
        }
    }
    //小根堆Comparator
    public class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }
    //大根堆Comparator
    public class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }
    //K最多可以串行做的项目，W初始金额，Profits[i]第i个项目的利润，Costs[i]第i个项目的花费
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i=0;i<Profits.length;i++) {
            nodes[i] = new Node(Profits[i],Capital[i]);
        }
        //小根堆
        PriorityQueue<Node> minCostQ = new PriorityQueue<Node>(new MinCostComparator());
        //大根堆
        PriorityQueue<Node> maxProfitsQ = new PriorityQueue<Node>(new MaxProfitComparator());
        //所有元素入堆
        for(Node node:nodes) {
            minCostQ.add(node);
        }
        //最多可以进行k个项目
        for (int i=0;i<k;i++) {
            while (!minCostQ.isEmpty()&&minCostQ.peek().c<=W) {
                //小根对花费最小的项目进入大根堆
                maxProfitsQ.add(minCostQ.poll());
            }
            if (maxProfitsQ.isEmpty())
                return W;
            Node node = maxProfitsQ.poll();
            W = W + node.p;
        }
        return W;
    }
}
