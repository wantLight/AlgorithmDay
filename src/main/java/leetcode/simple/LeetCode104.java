package leetcode.simple;

import leetcode.medium.TreeNode;

/**
 * 二叉树最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class LeetCode104 {

    int maxTreeLength = 0;

    public int maxDepth(TreeNode root) {
        depth(root);
        return maxTreeLength;
    }

    //return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    public int depth(TreeNode root){
        if (root == null){
            return 1;
        }
        int Left = depth(root.left);
        int Right = depth(root.right);
        maxTreeLength = Math.max(maxTreeLength,Math.max(Left,Right));
        return Math.max(Left,Right)+1;
    }
}
