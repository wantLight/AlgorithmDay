package leetcode.simple;

import leetcode.medium.TreeNode;

/**
 * 翻转二叉树
 */
public class LeetCode226 {

    // 前序遍历 中左右
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 保存右子树
        TreeNode rightTree = root.right;
        // 交换左右子树的位置
        root.right = invertTree(root.left);
        root.left = invertTree(rightTree);
        return root;
    }

}
