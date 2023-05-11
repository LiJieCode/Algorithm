package linkedList.test02;



/**
 * 题目地址：
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * 题目内容：
 * 反转链表
 */

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null){
            ListNode curr = head.next;
            head.next = res;
            res = head;
            head = curr;
        }
        return res;
    }
}
