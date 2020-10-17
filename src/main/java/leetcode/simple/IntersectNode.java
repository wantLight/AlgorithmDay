package leetcode.simple;

/**
 * 求两链表的相交节点
 *
 * @author xyzzg
 * @date 2020-10-17 11:25
 * @version 1.0
 */
public class IntersectNode {

    /**
     * 返回A链表B链表相交节点
     *
     * @param headA A链表
     * @param headB B链表
     * @return ListNode 相交节点
     */
    public ListNode getIntersectNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        // 第一轮:pointerA和pointerB第一次到达尾部会移向另一链表的表头
        // 第二轮:如果pointerA与pointerB相交就返回交点, 但不相交的话就是null了
        while(pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }
        return pointerA;
    }

}
