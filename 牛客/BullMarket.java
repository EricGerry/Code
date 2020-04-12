/**
 * @Author：Eric
 * @Date：2020/4/12 22:47
 */

/*
* 风口的猪-中国牛市
* 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。
* 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
* 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
* 若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。
* 输入数值范围：2<=n<=100,0<=prices[i]<=100
* 示例1
* 输入
* 3,8,5,1,7,8
* 输出
* 12
* */

public class BullMarket {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
        int sum = 0,temp;
        for(int i=0; i<prices.length; i++){
            temp = getMax(prices,0,i) + getMax(prices,i,prices.length-1);
            if(temp > sum) {
                sum = temp;
            }
        }
        return sum;
    }
    // 求最大start到end之间的最大利润函数
    public int getMax(int[] prices, int start, int end){
        int max = 0;
        int min = prices[start];
        for(int i=start+1; i<=end; i++){
            if(prices[i] < min) {
                min = prices[i];
            }
            if(prices[i]-min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
