package leetcode.medium.tree;

import leetcode.hard.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * https://leetcode-cn.com/problems/sort-list/
 *
 * 递归排序三部曲：1，快慢指针找中点；2，递归调用mergeSort，3，合并两个链表
 */
public class LeetCode148 {

    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null)
            return head;
        //使用快慢指针找到中点
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //分割为两个链表
        ListNode newList = slow.next;
        slow.next = null;
        //将两个链表继续分割
        ListNode left = sortInList(head);
        ListNode right = sortInList(newList);

        ListNode lhead = new ListNode(-1);
        // 答案就指向链表头部，输出next
        ListNode res = lhead;

        //归并排序
        while(left != null && right != null){
            if(left.val < right.val){
                lhead.next = left;
                left = left.next;
            }else{
                lhead.next = right;
                right = right.next;
            }
            // lhead向下一个前进
            lhead = lhead.next;
        }
        // 循环结束，判断左右链表是否为空，把剩余的那部分加上来
        lhead.next = left!=null?left:right;
        return res.next;
    }

}
