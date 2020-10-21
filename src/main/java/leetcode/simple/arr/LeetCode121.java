package leetcode.simple.arr;

/**
 *
 *
 * 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        /**
         * 记录【今天之前买入的最小值】
         * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
         * 比较【每天的最大获利】，取最大值即可
         */
        if(prices.length <= 1){
            return 0;
        }

        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            // 历史最大值 今天之前最小值买入，今天卖出的获利 比较
            max = Math.max(max, prices[i] - min);
            // 今天之前买入的最小值
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
