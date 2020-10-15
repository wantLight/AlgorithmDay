package leetcode.hard;

import leetcode.medium.TreeNode;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，=
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 递归遍历一棵树，只需关注当前的根节点就好，它的子树的遍历交给递归完成：
 * “serialize函数，请帮我序列化我的左右子树，我等你的返回结果，再追加到我身上。”
 * 选择前序遍历是因为 根|左|右根∣左∣右 的打印顺序，在反序列化时更容易定位出根节点的值。
 *
 *
 *
 */
public class LeetCode297 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            // 遇到 null 节点也要翻译成一个符号，反序列化时才知道这里对应 null。
            return "null,";
        }
        // 根 不需要特殊处理
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);

        return root.val + "," + leftStr + rightStr;
    }


    // Decodes your encoded data to tree.
    /**
     * 构建树的函数 buildTree 接收的 “状态” 是 list 数组，由序列化字符串转成
     * 按照前序遍历的顺序：先构建根节点，再构建左子树、右子树
     * 将 list 数组的首项弹出，它是当前子树的 root 节点
     * 如果它为 'X' ，返回 null
     * 如果它不为 'X'，则为它创建节点，并递归调用 buildTree 构建左右子树，当前子树构建完毕，向上返回
     */
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        Deque<String> dp = new LinkedList<>(Arrays.asList(temp));
        return buildTree(dp);
    }
    private TreeNode buildTree(Deque<String> dq){
        //一个一个出队
        String s = dq.poll();
        if (s.equals("X")) return null;
        // 前序遍历
        //先构建根节点
        TreeNode node = new TreeNode(Integer.parseInt(s));
        //构建左子树
        node.left = buildTree(dq);
        //构建右子树
        node.right = buildTree(dq);
        return node;
    }
}
