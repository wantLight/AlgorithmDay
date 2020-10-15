2020.10.12开启每日刷题模式。这里记录每日刷题进展与代码目录情况~

**数据结构的存储方式只有两种：数组（顺序存储）和链表（链式存储）。**
## 二叉树：
`快速排序就是个二叉树的前序遍历，归并排序就是个二叉树的后续遍历`
二叉树的问题难点在于，如何把题目的要求细化成每个节点需要做的事情

98(leetcode.medium):验证二叉搜索树（中序遍历，判断当前节点是否大于中序遍历的前一个节点）
543(leetcode.simple):二叉树的直径（后序遍历，将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者）
104(leetcode.simple):二叉树最大深度 return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
124(leetcode.Hard):二叉树中的最大路径和（后序遍历，经过root的单边分支最大和， 即Math.max(root, root+left, root+right)）
297(leetcode.Hard):二叉树的序列化与反序列化（前序遍历，DFS递归遍历一棵树，只需关注当前的根节点就好，它的子树的遍历交给递归完成）
101(leetcode.simple):对称二叉树（需要借助两个节点递归，递归的终止条件是两个节点都为空）
617(leetcode.simple):合并二叉树(先合并根节点,再递归合并左右子树)

226(leetcode.simple):翻转二叉树（咋遍历都行，用TreeNode整体保存子树）
## 链表：
25(leetcode.Hard): K 个一组翻转链表 （递归/链表的反转）



## 数组：
15(leetcode.medium): 三数之和 (排序+双指针)

## 字符串：
10leetcode.Hard): 正则表达式匹配 (动态规划)
5(leetcode.medium):最长回文子串 （顺序遍历，定位中间重复部分的最后一个字符，再从中间向左右扩散）