package leetcode.hard;

/**
 *  K 个一组翻转链表 https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *  k 是一个正整数，它的值小于或等于链表的长度。
 *  如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  你的算法只能使用常数的额外空间。
 *  你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 上个节点
        ListNode prev=null;
        // 当前节点
        ListNode cur=head;
        //（先用它递进看一下是不是有k个结点）
        ListNode S=head;
        // 下一个节点
        ListNode next=null;
        int count=0;
        int i=0;

        while (S != null && count != k){
            S = S.next;
            count++;
        }

        if (count == k){

            // 链表的反转
            while(i<k&&cur!=null){//递归的末端1
                //首先获取到递进的下一项防止结点丢失
                next=cur.next;
                //处理当前结点的指针，它本来应该指向下一个的，现在让它指向前一个
                cur.next=prev;
                //上个节点前进
                prev=cur;
                //当前节点前进
                //注意这里，不是cur=cur.next,因为cur的next已经重新指向前一位了，它的下一位已经丢失，所以第一步先把它的下一位用next保存下来了
                cur=next;
                i++;//这里学会了用prev来保存前一变量，
            }

            if(next!=null){//递归的传递端
                head.next=reverseKGroup(next,k);//在这里优化成了递归
            }
            return prev;//最终返回

        } else {
            return cur;
        }

    }



    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private ListNode reverseListedList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //将1号节点以后的链表反转
        ListNode newHead = reverseListedList(head.next);
        //以后的链表的下一个指向头节点
        head.next.next = head;
        //头节点的下一个指向指向null
        head.next = null;
        return newHead;
    }


}
