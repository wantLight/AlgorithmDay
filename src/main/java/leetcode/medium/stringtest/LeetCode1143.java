package leetcode.medium.stringtest;

/**
 *
 * 因为子序列类型的问题，穷举出所有可能的结果都不容易，
 * 而动态规划算法做的就是穷举 + 剪枝，它俩天生一对儿。所以可以说只要涉及子序列问题，十有八九都需要动态规划来解决。+
 *
 * 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 * 最长公共子序列问题是经典的动规题目。
 *
 * 动规分析如下：
 * 1.确定dp数组（dp table）以及下标的含义.
 * 说对于字符串 s1 和 s2，它们的长度分别是 m、n，一般来说都要构造一个这样的 DP table：
 * int[][] dp = new int[m+1][n+1]。 加1之后你就不需要去判断只是让索引为0的行和列表示空串。
 *
 * 2.定义 base case
 * 让索引为0的行和列表示空串，
 * dp[0][...] 和 dp[...][0] 都应该初始化为0，这就是base case。
 *
 * 3.找状态转移方程
 * 现在对比的这两个字符不相同的，那么我们要取它的「要么是text1往前退一格，要么是text2往前退一格，两个的最大值」
 * dp[i + 1][j + 1] = Math.max(dp[i+1][j], dp[i][j+1]);
 * 对比的两个字符相同，去找它们前面各退一格的值加1即可：dp[i+1][j+1] = dp[i][j] + 1;
 *
 *
 */
public class LeetCode1143 {

    // https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-tu-wen-jie-xi-by-yijiaoqian/
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 获取两个串字符
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }



}
