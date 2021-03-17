package leetcode.medium.arr;

import java.util.Arrays;

/**
 *
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 *
 * 这种找路径，找方法的题一般可以使用回溯法来解决，回溯法也可以说是树形图法，解题的时候使用类似于树状图的结构，使用 自顶而下 的方法。
 *
 * 而在回溯法中，如果含有很多的重复的计算的时候，就可以使用记忆化的搜索，将可能出现的重复计算大状态使用一个数组来保存其值，在进行重复的计算的时候，就可以直接的调用数组中的值，较少了不必要的递归。
 *
 * 使用了记忆化搜索后，一般还可以进行优化，在记忆化搜索的基础上，变成 自底而上 的动态规划。
 *
 * 链接：https://leetcode-cn.com/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
 */
public class LeetCode322 {

    private int num = 0;
    private int maxNum = -1;


    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount);
    }

    // F(S)：组成金额 S 所需的最少硬币数量
    // 不过是⼀个 N 叉树的遍历问题⽽已
    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


//    public int coinChange(int[] coins, int amount) {
//
//        num ++;
//        if (amount == 0){
//            maxNum = num;
//        }
//
//        for (int i=0 ; i < coins.length ; i++) {
//            if ( amount-num >= 0 ){
//                int coinChange = coinChange(coins, amount - num);
//                num = 0;
//            }
//        }
//
//        return maxNum;
//    }


    //明确「状态」
    //-> 定义 dp 数组/函数的含义
    //-> 明确「选择」
    //-> 明确 base case。
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //链接：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/

}
