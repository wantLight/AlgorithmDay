package leetcode.hard;


import leetcode.medium.TreeNode;

/**
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 *
 * 与543相同解法
 */
public class LeetCode124 {

    int result = Integer.MIN_VALUE;

    /**
     * 转化为对每一个节点来说，最大路径无非是 自己（如果值大于0） + 左边的最大值（如果值大于0） + 右边的最大值（如果值大于0）
     *
     * 经过root的单边分支最大和， 即Math.max(root, root+left, root+right)
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        maxValue(root);
        return result;
    }

    public int maxValue(TreeNode root){
        if (root == null){
            return 0;
        }
        //左：计算左边分支最大值，左边分支如果为负数还不如不选择
        int maxLeft = Math.max(0, maxValue(root.left));
        //右：计算右边分支最大值，右边分支如果为负数还不如不选择
        int maxRight = Math.max(0, maxValue(root.right));
        //中：经过root的分支最大和 / 与已经计算过历史最大值做比较
        result = Math.max(result, root.val + maxLeft + maxRight);
        // 返回经过root的单边最大分支给当前root的父节点计算使用
        return root.val + Math.max(maxLeft, maxRight);
    }

}
