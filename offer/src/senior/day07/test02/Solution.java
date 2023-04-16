package senior.day07.test02;

import sun.util.resources.cldr.eu.CurrencyNames_eu;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目地址：
 * https://leetcode.cn/problems/c32eOV/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117
 *
 * 题目内容：
 * 【剑指 Offer II 022. 链表中环的入口节点】
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。
 * 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 *
 * ******理论待写******
 *
 */
 public class Solution {
     // 哈希表方法
     public ListNode detectCycle(ListNode head) {
         // Map<> nodeMap = new HashMap()
         ListNode pos = head;
         Set<ListNode> nodeSet = new HashSet<>();
         while (pos != null){
             if (nodeSet.contains(pos)){
                 return pos;
             } else {
                 nodeSet.add(pos);
             }
             pos = pos.next;
         }
         return null;
     }

     // 双指针方法
     // 理论待写
     public ListNode detectCycle1(ListNode head) {
         ListNode fast = head;
         ListNode slow = head;

         while (true) {
             if (fast == null || fast.next == null) return  null;
             fast = fast.next.next;
             slow = slow.next;
             if (fast == slow) break;
         }

         // 说明第一次相遇了
         // 构造第二次相遇
         ListNode slow2 = head;
         while (slow2 != slow) {
             slow = slow.next;
             slow2 = slow2.next;
         }
         return slow;
     }
 }