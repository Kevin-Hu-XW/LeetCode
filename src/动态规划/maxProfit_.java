package 动态规划;


/*
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0

    思路:我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：
         如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案

 */
public class maxProfit_ {
    //方法一：超出限制
    public static int maxProfit1(int[] prices) {
        if (prices.length==0)
            return 0;
        int max=0;
        int profit = 0;
        for (int i=0;i<prices.length-1;i++){
            for (int j=i+1;j<prices.length;j++){
                profit = prices[j]-prices[i];
                if (profit>=max){
                    max = profit;
                }
            }
        }
        return max;
    }


    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++){
            if (prices[i]<minPrice)
                minPrice = prices[i];
            else if (prices[i]-minPrice>maxprofit){
                maxprofit = prices[i]-minPrice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int max = maxProfit(prices);
        System.out.println(max);
    }
}
