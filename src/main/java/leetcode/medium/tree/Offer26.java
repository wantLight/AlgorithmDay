package leetcode.medium.tree;

import leetcode.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 */
public class Offer26 {


    /**
     * 以 节点 AA 为根节点的子树 包含树 BB ，对应 recur(A, B)；
     * 树 BB 是 树 AA 左子树 的子结构，对应 isSubStructure(A.left, B)；
     * 树 BB 是 树 AA 右子树 的子结构，对应 isSubStructure(A.right, B)；
     *
     *
     * 先序遍历树 A 中的每个节点 n_An；（对应函数 isSubStructure(A, B)）
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if ( A == null || B == null){
            return false;
        }

        // 以 节点 AA 为根节点的子树 包含树 BB
        // 实质上是在对树 A 做 先序遍历
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断树 AA 中 以 n_An为根节点的子树 是否包含树 BB 。（对应函数 recur(A, B)）
    boolean recur(TreeNode A, TreeNode B) {

        // 当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true ；
        if (B == null) {
            return true;
        }
        // 当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
        // 当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
        if (A == null || A.val != B.val){
            return false;
        }

        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
