package leetcode.medium;

/**
 *  验证二叉搜索树
 *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 *  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST，继续遍历；否则直接返回 false。
 */
public class LeetCode98 {

    // 递归获取的上一个值
    long pre = Long.MIN_VALUE;

    // 递归想当前节点就可以了，不要往下想
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        // 中序遍历 左中右
        // 左边的值一定要大于节点，所以是！
        if (!isValidBST(root.left)){
            return false;
        }
        // 中
        if (root.val <= pre ){
            return false;
        }
        pre = root.val;
        // 右
        return isValidBST(root.right);
    }
}
