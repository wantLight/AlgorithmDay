package leetcode.medium;

/**
 * 最长回文子串
 *
 */
public class LeetCode5 {


    // 动态规划
    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                // j = 起始地址 + 现在判断的长度
                int j = i + l;
                if (l == 0) {
                    // 对于长度为 1 的子串，它显然是个回文串；
                    dp[i][j] = true;
                } else {
                    boolean bool = s.charAt(i) == s.charAt(j);
                    if (l == 1) {
                        // 对于长度为 2 的子串，只要它的两个字母相同，它就是一个回文串。
                        dp[i][j] = bool;
                    } else {
                        // 对于长度大于 2 的子串，只有 s[i+1:j-1]s[i+1:j−1] 是回文串，并且s 的第 i 和 j 个字母相同时，s[i:j]s[i:j] 才会是回文串。
                        // 动态规划的状态转移方程。
                        dp[i][j] = (bool && dp[i + 1][j - 1]);
                    }
                }

                // 起始长度+1
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         目前已定位中间部分的最后一个字符 中间的字符串就是low 到 high
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度（答案~）
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
