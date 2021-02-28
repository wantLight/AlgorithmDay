package leetcode.simple.tree;

import leetcode.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 */
public class Offer54 {

    private int ans = 0, count = 0;
    public int kthLargest2(TreeNode root, int k) {
        // clarification:  root == null?   k <= 1?
        helper(root, k);
        return ans;
    }

    private void helper(TreeNode root, int k) {
        if (root.right != null) helper(root.right, k);

        if (++count == k) {
            ans = root.val;
            return;
        }

        if (root.left != null) helper(root.left, k);
    }



    public int kthLargest(TreeNode root, int k) {
        if ( root == null ){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        // Java中是值传递而不是引用传递。
        // 对于对象来说传递的是引用的一个副本给参数
        search(root, list);
        return list.get(k);
    }

    // 当遍历到了第K大数的时候，就可以停止遍历了，同时，把遍历到节点对应的数保存下来即可。
    public void search(TreeNode root, List<Integer> list){

        if (root == null){
            return;
        }

        if (root.left != null){
            search(root.left,list);
        }
        list.add(root.val);
        if (root.right != null){
            search(root.right,list);
        }

    }
}
