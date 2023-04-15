package linkedList.test01;
/**
 * 题目地址：
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * 题目内容：
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 解题思路：
 *
 */

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] reversePrint(ListNode head) {

        if (head == null) return new int[0];

        LinkedList<Integer> ans = new LinkedList<>();

        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }

        // 反转，存储到数组中
        int N = ans.size();
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = ans.removeLast();
        }
        return result;
    }
}
