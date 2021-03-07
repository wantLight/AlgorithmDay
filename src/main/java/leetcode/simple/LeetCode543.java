package leetcode.simple;

import leetcode.medium.TreeNode;

/**
 * 求二叉树的任意两个节点的最长距离
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点
 *
 * 这就是124题的简单版本
 */
public class LeetCode543 {

    static int maxTreeLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxTreeLength;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int Left = depth(root.left);
        int Right = depth(root.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        maxTreeLength=Math.max(Left+Right,maxTreeLength);
        //返回节点深度
        return Math.max(Left,Right)+1;
    }

}
