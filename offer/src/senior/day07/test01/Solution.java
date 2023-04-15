package senior.day07.test01;

/**
 * 题目地址：
 * https://leetcode.cn/problems/SLwz0R/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117
 *
 * 题目内容：
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 解题思路：
 * 先遍历一遍，记录链表的长度，再去删除指定的节点。
 * 这里创建了一个哑节点，是为了不对头节点进行特殊判断了。
 *
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个哑节点
        ListNode dummy = new ListNode(0, head);
        int L = 0;
        ListNode temp = dummy;
        while (temp != null){
            temp = temp.next;
            L++;
        }
        ListNode curr = dummy;
        for (int i = 1; i < L - n; i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }
}
