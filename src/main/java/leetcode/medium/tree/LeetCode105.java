package leetcode.medium.tree;

import leetcode.medium.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 与654感觉有点像
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    /*
     递归：限定数据范围  构造二叉树，返回根节点
     */
    public TreeNode build(int[] preorder,int preStart,int preEnd,
                          int[] inorder,int inStart,int inEnd){
        if (preStart > preEnd){
            return null;
        }
        int preVal = preorder[preStart];
        int index = -1;
        for (int i = inStart; i <= inEnd ; i++) {
            if (preVal == inorder[i]){
                index = i;
                break;
            }
        }
        // 根节点一定是前序的第一个数
        TreeNode treeNode = new TreeNode(preVal);

        // preStart + leftSize
        int leftSize = index - inStart;

        treeNode.left = build(preorder,preStart+1,preStart + leftSize,
                inorder,inStart,index-1);
        treeNode.right = build(preorder,preStart + leftSize+1,preEnd,
                inorder,index+1,inEnd);
        return treeNode;
    }

}
