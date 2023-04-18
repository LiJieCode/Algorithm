# 分类刷题

- [Leetcode面试高频题分类刷题总结 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/349940945)
- [LeetCode 刷题顺序，按标签分类，科学刷题！ - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/501483324)
- [LeetCode 题目分类（持续更新中...） - 哔哩哔哩 (bilibili.com)](https://www.bilibili.com/read/cv15395653/)



## 回溯算法







## 动态规划







## 二分查找







## 链表

- [剑指 Offer 06. 从尾到头打印链表 - 力扣（Leetcode）](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/description/)

  ```java
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
  ```

- 





## 树

- 深度优先搜索

```java
```



- 广度优先搜索

```java
// 先序遍历



// 中序遍历


// 后序遍历


```



- 

