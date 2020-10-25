2020.10.12开启每日刷题模式。这里记录每日刷题进展与代码目录情况~

**数据结构的存储方式只有两种：数组（顺序存储）和链表（链式存储）。**
## 二叉树：
`快速排序就是个二叉树的前序遍历，归并排序就是个二叉树的后续遍历`
二叉树的问题难点在于，如何把题目的要求细化成每个节点需要做的事情。还要考虑递归的终止条件！！
**写递归算法要明确函数的定义，相信它，不要跳入进去**
对于构造二叉树的问题，根节点要做的就是把想办法把自己构造出来。
按照题目要求细化，明确根节点应该干什么，剩下的交给遍历框架处理。

### 98(leetcode.medium):验证二叉搜索树
（中序遍历，判断当前节点是否大于中序遍历的前一个节点）
### 543(leetcode.simple):二叉树的直径
（后序遍历，将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者）
### 104(leetcode.simple):二叉树最大深度 
return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
### 124(leetcode.Hard):二叉树中的最大路径和
（后序遍历，经过root的单边分支最大和， 即Math.max(root, root+left, root+right)）
### 297(leetcode.Hard):二叉树的序列化与反序列化
（前序遍历，DFS递归遍历一棵树，只需关注当前的根节点就好，它的子树的遍历交给递归完成）
### 101(leetcode.simple):对称二叉树
（需要借助两个节点递归，递归的终止条件是两个节点都为空）
### 617(leetcode.simple):合并二叉树
(先合并根节点,再递归合并左右子树)
### 654(leetcode.medium):最大二叉树
终止条件：当l>r时，说明数组中已经没元素了，自然当前返回的节点为null。
一次递归做了什么：找当前范围为[l,r]的数组中的最大值作为root节点，
### 226(leetcode.simple):翻转二叉树
（咋遍历都行，用TreeNode整体保存子树）


## 链表：
### 25(leetcode.Hard): K 个一组翻转链表 
（递归/链表的反转）
### 2(leetcode.medium):两数相加
放一个数字代表进位


单链表和双链表的反转（100%）

## 数组：
动态规划：先考虑最简单的情况，从这里开始推移。

 memo[i] 表示考虑抢劫 nums[i...n-1] 所能获得最大收益（不是说一定从 i 开始抢劫）
 先考虑最简单的情况 memo[n - 1] = nums[n - 1];
 memo[i] 的取值在考虑抢劫 i 号房子和不考虑抢劫之间取最大值 
 memo[i] = Math.max(nums[i] + (i + 2 >= n ? 0 : memo[i + 2]), nums[i + 1] + (i + 3 >= n ? 0 : memo[i + 3]));

### 121(leetcode.simple) 买卖股票的最佳时机
动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}

### 40(leetcode.simple) 最小的k个数 （腾讯面试题）
单边循环法 --- 快排切分 （根据下标j与k-1的大小关系来决定继续切分左段还是右段。）

### 数组存在两个出现奇数次数的值，按序输出（60%）

### 15(leetcode.medium): 三数之和 
(排序+双指针)

## 字符串：
### 10leetcode.Hard): 正则表达式匹配 
(动态规划)
### 5(leetcode.medium):最长回文子串 
（顺序遍历，定位中间重复部分的最后一个字符，再从中间向左右扩散）
### 3(leetcode.medium):无重复字符的最长子串
