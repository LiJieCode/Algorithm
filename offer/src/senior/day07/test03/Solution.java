package senior.day07.test03;

/**
 * 题目地址：
 * https://leetcode.cn/problems/3u1WK4/description/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117
 *
 * 题目内容：
 * 【剑指 Offer II 023. 两个链表的第一个重合节点】
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null。
 *
 * 解题思路：
 * “我走过我的世界，再从你的世界走一遍”
 * “你走过你的世界，再从我的世界走一遍”
 * “最终我们将相遇，可能在途中（公共节点），可能在结尾（null）”
 *
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // if (headA == null || headB == null) return null;

        ListNode node1 = headA, node2 = headB;

        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }

        return node1;

    }
}
