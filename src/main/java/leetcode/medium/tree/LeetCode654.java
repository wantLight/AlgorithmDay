package leetcode.medium.tree;

import leetcode.medium.TreeNode;

/**
 * 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 * 树的递归很多时候都可以套路解决，就一个模版，递归套路三部曲：
 * 找终止条件：当l>r时，说明数组中已经没元素了，自然当前返回的节点为null。
 * 每一级递归返回的信息是什么：返回的应该是当前已经构造好了最大二叉树的root节点。
 *
 * 一次递归做了什么：找当前范围为[l,r]的数组中的最大值作为root节点，
 * 然后将数组划分成[l,bond-1]和[bond+1,r]两段，并分别构造成root的左右两棵子最大二叉树。
 */
public class LeetCode654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }

    public TreeNode buildTree(int[] nums,int start,int end){
        if (start > end){
            return null;
        }
        // 找出最大元素
        // 对于构造二叉树的问题，根节点要做的就是把想办法把自己构造出来。
        int maxData = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i]>maxData){
                index = i;
                maxData = nums[i];
            }
        }
        // 二叉树的根是数组中的最大元素。 找当前范围为[l,r]的数组中的最大值作为root节点，
        TreeNode treeNode = new TreeNode(maxData);
        // 左子树是通过数组中最大值左边部分构造出的最大二叉树
        treeNode.left = buildTree(nums, start, index-1);
        treeNode.right = buildTree(nums, index+1, end);
        return treeNode;
    }
}
