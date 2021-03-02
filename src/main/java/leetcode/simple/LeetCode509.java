package leetcode.simple;

/**
 *
 * https://leetcode-cn.com/problems/fibonacci-number/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-labuladong/
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 动规分析如下：
 * 1.确定dp数组（dp table）以及下标的含义.
 *
 * 2.定义 base case
 *
 * 3.找状态转移方程
 * F(n) = F(n - 1) + F(n - 2)
 * 根据斐波那契数列的状态转移方程，当前状态只和之前的两个状态有关，
 * 其实并不需要那么长的一个 DP table 来存储所有的状态，只要想办法存储之前的两个状态就行了。
 *
 *
 */
public class LeetCode509 {

    public int fib(int n) {
        if (n < 2){
            return n;
        }

        int prev = 0;
        int now = 1;
        int result = 0;

        for (int i=2; i<n; i++){
            result = prev + now;
            prev = now;
            now = result;
        }
        return result;
    }

}
