# 剑指Offer



##  更新日志：
- 2023年4月18日
  - 更新文件：class/src/tree/BFS、/DFS
    - 主要更新了二叉树的广度优先搜索和深度优先搜索
    - 深度优先分为：先序遍历、中序遍历、后序遍历，代码都已给出
  - 更新文件：/offer/src/senior/day16/test01
    - 题目：二叉树剪枝
- 









## 初级

### 第一天

- 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 `appendTail` 和 `deleteHead` ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，`deleteHead` 操作返回 -1 )

  > [剑指 Offer 09. 用两个栈实现队列 - 力扣（Leetcode）](https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  public class CQueue {
      LinkedList<Integer> A, B;
      public CQueue() {
          A = new LinkedList<>();
          B = new LinkedList<>();
      }
  
      public void appendTail(int value) {
          A.add(value);
      }
  
      public int deleteHead() {
          if (!B.isEmpty()){
              return B.removeLast();
          }else if (!A.isEmpty()){
              for (int i = A.size() - 1; i >= 0; i --) {
                  B.add(A.removeLast());
              }
              return B.removeLast();
          } else {
              return -1;
          }
      }
  }
  
  /**
   * Your CQueue object will be instantiated and called as such:
   * CQueue obj = new CQueue();
   * obj.appendTail(value);
   * int param_2 = obj.deleteHead();
   */
  ```

- 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

  > [剑指 Offer 30. 包含min函数的栈 - 力扣（Leetcode）](https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  > 总结：
  >
  > - 利用两个LinkedList
  > - 一个负责存储数据，一个负责实时存储最小值

  ```java
  class MinStack {
      LinkedList<Integer> xStack, minStack;
      /** initialize your data structure here. */
      public MinStack() {
          xStack = new LinkedList<>();
          minStack = new LinkedList<>();
          minStack.push(Integer.MAX_VALUE);
      }
  
      public void push(int x) {
          // 元素进栈
          xStack.push(x);
          // 
          minStack.push(Math.min(minStack.peek(), x));
      }
  
      public void pop() {
          xStack.pop();
          minStack.pop();
      }
  
      public int top() {
          return xStack.peek();
      }
  
      public int min() {
          return minStack.peek();
      }
  }
  
  /**
   * Your MinStack object will be instantiated and called as such:
   * MinStack obj = new MinStack();
   * obj.push(x);
   * obj.pop();
   * int param_3 = obj.top();
   * int param_4 = obj.min();
   */
  ```


### 第二天

- 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

  > [剑指 Offer 06. 从尾到头打印链表 - 力扣（Leetcode）](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
  class Solution {
      public int[] reversePrint(ListNode head) {
          Stack<ListNode> stack = new Stack<>();
          ListNode temp = head;
          while (temp != null) {
              stack.push(temp);
              temp = temp.next;
          }
          int size = stack.size();
          int[] print = new int[size];
          for (int i = 0; i < size; i++) {
              print[i] = stack.pop().val;
          }
          return print;
      }
  }
  ```

- 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

  > [剑指 Offer 24. 反转链表 - 力扣（Leetcode）](https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  > 总结：
  >
  > - 链表的赋值，其实只是把一个链表指向了另一个链表，存储的还是一个链表
  > - 除非你新声明一个链表，这样存储的才是另一个链表

  ```java
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
  class Solution {
   public ListNode reverseList(ListNode head) {
          ListNode prev = null;
          ListNode curr = head;
          while (curr != null) {
              ListNode next = curr.next;
              // 这个的原因是，让已存在的列表的元素依次指向新的链表
              curr.next = prev;
              prev = curr;
              curr = next;
          }
          return prev;
      }
  }
  ```

- 请实现 `copyRandomList` 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 `next` 指针指向下一个节点，还有一个 `random` 指针指向链表中的任意节点或者 `null`。

  > [剑指 Offer 35. 复杂链表的复制 - 力扣（Leetcode）](https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  
  ```


### 第三天

- [剑指 Offer 05. 替换空格 - 力扣（Leetcode）](https://leetcode.cn/problems/ti-huan-kong-ge-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 58 - II. 左旋转字符串 LCOF - 力扣（Leetcode）](https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第四天

- [剑指 Offer 03. 数组中重复的数字 LCOF - 力扣（Leetcode）](https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 53 - I. 在排序数组中查找数字 I - 力扣（Leetcode）](https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 53 - II. 0～n-1中缺失的数字 - 力扣（Leetcode）](https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第五天

- [剑指 Offer 04. 二维数组中的查找 - 力扣（Leetcode）](https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 11. 旋转数组的最小数字 - 力扣（Leetcode）](https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 50. 第一个只出现一次的字符 - 力扣（Leetcode）](https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第六天 -  搜索与回溯算法：简单

- 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。<span style ="color:blue; font-weight:bold">（广度优先搜索）</span>

  > [剑指 Offer 32 - I. 从上到下打印二叉树 - 力扣（Leetcode）](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      public int[] levelOrder(TreeNode root) {
          if (root == null) return new int[0];
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
          ArrayList<Integer> ans = new ArrayList<>();
          while(!queue.isEmpty()){
              TreeNode node = queue.poll();
              ans.add(node.val);
              if (node.left != null) queue.add(node.left);
              if (node.right != null) queue.add(node.right);
          }
          int[] res = new int[ans.size()];
          for (int i = 0; i < ans.size(); i++){
              res[i] = ans.get(i);
          }
          return res;
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 广度优先搜索(BFS)，一般借助队列的先进先出实现
  >
  > - 解题思路：
  >
  >   - 利用一个**队列(先进先出)**保存树的节点，
  >
  >   - 利用一链表存储节点值
  >
  >   - 最后再放到一个数值中返回

- 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 

  每一层用一个List存储，返回一个二维List

  > [剑指 Offer 32 - II. 从上到下打印二叉树 II - 力扣（Leetcode）](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> res = new ArrayList<>();
          if (root == null) return res;
  
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
  
          while (!queue.isEmpty()) {
              List<Integer> temp = new ArrayList<>();
              int size = queue.size();
              for (int i = 0; i < size; i++) {
                  TreeNode node = queue.poll();
                  temp.add(node.val);
                  if (node.left != null) queue.add(node.left);
                  if (node.right != null) queue.add(node.right);
              }
              res.add(temp);
          }
          return res;
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 广度优先搜索的思路
  >
  > - `while (!queue.isEmpty()) ` while循环的每一轮要将queue队列清空，所以这里用了一个for循环
  >
  > - 对内部for循环的修改
  >
  >   - ```java
  >     // for (int i = 0; i < queue.size; i++)
  >     // 因为 queue 一直在变，queue.size 会多次执行，这样写不行，所以要先将他的大小给赋值给size
  >                                       
  >     int size = queue.size();
  >     for (int i = 0; i < size; i++) {
  >         TreeNode node = queue.poll();
  >         temp.add(node.val);
  >         if (node.left != null) queue.add(node.left);
  >         if (node.right != null) queue.add(node.right);
  >     }
  >                                       
  >     // *********这个写法真的秀***************************************
  >     // 因为循环体中的代码和i无关，所以这里直接倒序，这样 queue.size() 只执行了一次，没问题
  >     for(int i = queue.size(); i > 0; i--) {
  >         TreeNode node = queue.poll();
  >         tmp.add(node.val);
  >         if(node.left != null) queue.add(node.left);
  >         if(node.right != null) queue.add(node.right);
  >     }
  >     ```
  >
  > - 

- 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

  > [剑指 Offer 32 - III. 从上到下打印二叉树 III - 力扣（Leetcode）](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  public class Solution {
      public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();
          if (root == null) return result;
  
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
  
          boolean flag = true;
          while (!queue.isEmpty()) {
              Deque<Integer> deque = new LinkedList<>();
              for (int i = queue.size(); i > 0; i--) {
                  TreeNode poll = queue.poll();
                  if (flag) deque.offerLast(poll.val);
                  else deque.offerFirst(poll.val);
                  if (poll.left != null) queue.offer(poll.left);
                  if (poll.right != null) queue.offer(poll.right);
              }
              LinkedList<Integer> linkedList = new LinkedList<>(deque);
              // result.add(new LinkedList<>(deque));
              result.add(linkedList);
              flag = !flag;
          }
          return result;
      }
  }
  ```
  
  > 总结，沉淀：
  >
  > - 本题要求二叉树的每层节点的数据依次反向记录，所以就借助了一个boolean变量打标记
  >
  > - ` Deque<Integer> deque = new LinkedList<>();` 声明一个Deque(双端队列)是很好的想法，可以根据不同层，相反的插入数据
  >
  > - `LinkedList<Integer> linkedList = new LinkedList<>(deque);`
  >
  >   - 这里学到了集合的一个传入参数的构造方法，之前没有关注过
  >
  >     ```java
  >     LinkedList(Collection<? extends E> c)
  >     // 构造一个包含指定集合的元素的列表，按照它们由集合的迭代器返回的顺序。
  >     ```
  >
  > - 
  

### 第七天 - 搜索与回溯算法：简单

- 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

  B是A的子结构， 即 A中有出现和B相同的结构和节点值。

  > [剑指 Offer 26. 树的子结构 - 力扣（Leetcode）](https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      public boolean isSubStructure(TreeNode A, TreeNode B) {
          // return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
          // 如果 A 和 B 任意一个为 null 则返回false
          if (A == null || B == null) return false;
  		// 
          return recur(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
      }
  
      // 判断 以A为头节点 和 以B为头节点， B 是否是A的子树
      // 三种情况：如果递归到 B == null 说明匹配上了，返回true
      //         如果递归到 A == null 说明没有匹配上，返回false
      //         如果遇到了 A的节点值和B的节点值不相等，返回false
      boolean recur(TreeNode A, TreeNode B) {
          if (B == null) return true;
          if (A == null || A.val != B.val) return false;
          // 继续递归判断 节点的左右子树，必须保证左右子树都相等，才返回true
          return recur(A.left, B.left) && recur(A.right, B.right);
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 

- 请完成一个函数，输入一个二叉树，该函数输出它的镜像。

  > [剑指 Offer 27. 二叉树的镜像 - 力扣（Leetcode）](https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      public TreeNode mirrorTree(TreeNode root) {
          if (root == null) return root;
          
          TreeNode temp = root.left;
          root.left = mirrorTree(root.right);
          root.right = mirrorTree(temp);
  
          return root;
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 

- 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

  > [剑指 Offer 28. 对称的二叉树 - 力扣（Leetcode）](https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      // 这是判断一个树是不是自己对称
      public boolean isSymmetric(TreeNode root) {
          // 如果root为null，则对称
          // 如果root不为null，则判断(root.left, root.right)是不是相互对称
          return root == null ? true : recur(root.left, root.right);
      }
      
      // 这是判断两个树是不是相互对称，或者说相互镜面
      // 判断以L为头节点 和 以R为头节点的两个树，是不是对称。
      boolean recur(TreeNode L, TreeNode R) {
          if(L == null && R == null) return true;
          if(L == null || R == null || L.val != R.val) return false;
          return recur(L.left, R.right) && recur(L.right, R.left);
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 

### 第八天 - 动态规划：简单

- 写一个函数，输入 `n` ，求斐波那契（Fibonacci）数列的第 `n` 项（即 `F(N)`）。斐波那契数列的定义如下：

  ```
  F(0) = 0,   F(1) = 1
  F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
  ```

  斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

  答案需要取模 `1e9+7`（1000000007），如计算初始结果为：1000000008，请返回 1。

  > [剑指 Offer 10- I. 斐波那契数列 - 力扣（Leetcode）](https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  public class Solution {
  //    public int fib(int n) {
  //        final int MOD = 1000000007;
  //
  //        if (n < 2) return n;
  //
  //        int p = 0, q = 0, r = 1;
  //        for (int i = 2; i <= n; ++i) {
  //            p = q;
  //            q = r;
  //            r = (p + q) % MOD ;
  //        }
  //        return r ;
  //    }
  
      // 0 1 1 2 3 5
      public int fib(int n) {
  
          if (n < 2) return n;
          int last = 1, nextToLast = 0, answer = 0;
          
          for (int i = 1; i < n; i++) {
              answer = (last + nextToLast) % 1000000007;
              nextToLast = last;
              last = answer;
          }
          return answer;
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 起始值：0 1      i = 0，i  = 1
  > - 一轮后：0 1 1        i = 2
  > - 二轮后：1 1 2        i = 3
  > - 三轮后：1 2 3        i = 4

- 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 `n` 级的台阶总共有多少种跳法。

  答案需要取模 `1e9+7（1000000007）`，如计算初始结果为：1000000008，请返回 1。

  > [剑指 Offer 10- II. 青蛙跳台阶问题 - 力扣（Leetcode）](https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  public class Solution {
      public int numWays(int n) {
  
          if (n == 0) return 1;
          if (n == 1) return 1;
  
          int nextToLast = 1, last = 1, answer = 0;
          for (int i = 1; i < n; i++) {
              answer = (last + nextToLast) % 1000000007;
              nextToLast = last;
              last = answer;
          }
  
          return answer;
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 

- 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

  > [剑指 Offer 63. 股票的最大利润 - 力扣（Leetcode）](https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  public class Solution {
  
      // prices : [7,1,5,3,6,4]
      public int maxProfit(int[] prices) {
          int cost = Integer.MAX_VALUE, profit = 0;
          for (int price : prices) {
              cost = Math.min(cost, price);
              profit = Math.max(profit, price - cost);
          }
          return profit;
      }
  }
  ```
  
  > 总结，沉淀：
  >
  > - 做题思路：
  >   - 给了一个数组【8 4 2 7 6 4 3 1 8 9 4】，算利润最大值
  >   - 遍历数组的值，cost 一直选最小值，profit 一直选最大值。

### 第九天 - 动态规划：中等

- 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

  要求时间复杂度为O(n)。

  > [剑指 Offer 42. 连续子数组的最大和 - 力扣（Leetcode）](https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  public class Solution {
      // public int maxSubArray(int[] nums) {
      //     int N = nums.length;
      //     int[] dp = new int[N];
      //     int result = nums[0];
      //     dp[0] = nums[0];
      //     for (int i = 1; i < N; i++) {
      //         dp[i] = nums[i] + Math.max(dp[i - 1], 0);
      //         result = Math.max(result, dp[i]);
      //     }
      //     return result;
      // }
  
      public int maxSubArray(int[] nums) {
          int N = nums.length;
          int result = nums[0];
          for (int i = 1; i < N; i++) {
              nums[i] += Math.max(nums[i - 1], 0);
              result = Math.max(result, nums[i]);
          }
          return result;
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 

- 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

  > [剑指 Offer 47. 礼物的最大价值 - 力扣（Leetcode）](https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      //  public int maxValue(int[][] grid) {
      //     int m = grid.length;
      //     int n = grid[0].length;
      //     if (m == 0 || n == 0) return 0;
      //     // 初始值
      //     for (int i = 1; i < m; i++) {
      //         grid[i][0] += grid[i - 1][0];
      //     }
      //     for (int i = 1; i < n; i++) {
      //         grid[0][i] += grid[0][i - 1];
      //     }
      //     if (m == 1) return grid[0][n - 1];
      //     if (n == 1) return grid[m - 1][0];
      //     int maxValue = Integer.MIN_VALUE;
  
      //     for (int i = 1; i < m; i++) {
      //         for (int j = 1; j < n; j++) {
      //             grid[i][j] += Math.max(grid[i - 1][j] , grid[i][j - 1]);
      //             maxValue = Math.max(maxValue, grid[i][j]);
      //         }
      //     }
      //     return maxValue;
  
      // }
  
      // public int maxValue(int[][] grid) {
      //     int m = grid.length, n = grid[0].length;
      //     for(int i = 0; i < m; i++) {
      //         for(int j = 0; j < n; j++) {
      //             if(i == 0 && j == 0) continue;
      //             if(i == 0) grid[i][j] += grid[i][j - 1] ;
      //             else if(j == 0) grid[i][j] += grid[i - 1][j];
      //             else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
      //         }
      //     }
      //     return grid[m - 1][n - 1];
      // }
  
      public int maxValue(int[][] grid) {
  
          int m = grid.length;
          int n = grid[0].length;
  
          if (m == 0 || n == 0) return 0;
          
          // 初始值
          for (int i = 1; i < m; i++) {
              grid[i][0] += grid[i - 1][0];
          }
          for (int i = 1; i < n; i++) {
              grid[0][i] += grid[0][i - 1];
          }
          
          
          for (int i = 1; i < m; i++) {
              for (int j = 1; j < n; j++) {
                  grid[i][j] += Math.max(grid[i - 1][j] , grid[i][j - 1]);
              }
          }
          return grid[m -1][n-1];
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 一个很相似的问题，问题描述：一个机器人位于⼀个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
  >   机器人每次只能向下或者向右移动一步。机器人试图达到⽹网格的右下角（在下图中标记为“Finish”）。
  >   问总共有多少条不同的路径？  
  >
  >   ```java
  >   public class Solution {
  >                                             
  >       // prices : [7,1,5,3,6,4]
  >       public int uniquePaths(int m, int n) {
  >                                             
  >           // 动态规划，dp
  >           int[][] dp = new int[m][n];
  >                                             
  >           // 初始化初值
  >           for (int i = 0; i < m; i++) {
  >               dp[i][0] = i;
  >           }
  >           for (int i = 0; i < n; i++) {
  >               dp[0][i] = i;
  >           }
  >                                             
  >           for (int i = 1; i < m; i++) {
  >               for (int j = 1; j < n; j++) {
  >                   dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
  >               }
  >           }
  >           return dp[m - 1][n - 1];
  >       }
  >   }
  >   ```
  >
  > - 二维动态规划：





### 第十天 - 动态规划：中等

- 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

  > [剑指 Offer 46. 把数字翻译成字符串 - 力扣（Leetcode）](https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      public int translateNum(int num) {
          char[] chars = String.valueOf(num).toCharArray();
          int N = chars.length;
          int[] dp = new int[N + 1];
          dp[0] = 1;
          dp[1] = 1;
          for (int i = 2; i <= N; i++) {
              int m = Integer.parseInt(String.valueOf(chars[i - 2]));
              int n = Integer.parseInt(String.valueOf(chars[i - 1]));
              int sum = 10 * m + n;
              if (sum <= 25 && m > 0) {
                  dp[i] = dp[i - 1] + dp[i - 2];
              } else {
                  dp[i] = dp[i - 1];
              }
          }
          return dp[N];
      }
  }
  ```

  > 总结，沉淀：
  >
  > - ```java
  >   if (sum <= 25 && m > 0) {
  >       dp[i] = dp[i - 1] + dp[i - 2];
  >   } else {
  >       dp[i] = dp[i - 1];
  >   }
  >   ```
  >
  > - 如果遍历的当前数和前一个数组合之后小于等于25，则dp数组中前两个加起来是当前位置的值
  >
  > - 如果遍历的当前数和前一个数组合之后大于25，则dp数组中当前位置的值就等于前一个位置的值

- 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

  > [剑指 Offer 48. 最长不含重复字符的子字符串 - 力扣（Leetcode）](https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/description/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      // public int lengthOfLongestSubstring(String s) {
      //     Map<Character, Integer> dic = new HashMap<>();
  
      //     int res = 0, tmp = 0;
  
      //     for(int j = 0; j < s.length(); j++) {
      //         int i = dic.getOrDefault(s.charAt(j), -1);  // 获取索引 i
      //         dic.put(s.charAt(j), j);                    // 更新哈希表
      //         tmp = tmp < j - i ? tmp + 1 : j - i;        // dp[j - 1] -> dp[j]
      //         res = Math.max(res, tmp);                   // max(dp[j - 1], dp[j])
      //     }
  
      //     return res;
      // }
  
  
      public int lengthOfLongestSubstring(String s) {
          Map<Character, Integer> dic = new HashMap<>();
          int i = -1, res = 0;
          for(int j = 0; j < s.length(); j++) {
              if(dic.containsKey(s.charAt(j)))
                  i = Math.max(i, dic.get(s.charAt(j)));  // 更新左指针 i
              dic.put(s.charAt(j), j);                    // 哈希表记录
              res = Math.max(res, j - i);                 // 更新结果
          } 
          return res;
      }
  }
  ```
  
  > 总结，沉淀：
  >
  > - 

#### 动态规划在总结

- 步骤
  - 声明dp数组，定义数组元素代表的含义
  - 找出数组元素之间的关系式
  - 找出dp数组的初始值
- 如果dp数组当前位置的值**只和**前一个位置的值有关系，则可以不需要生成一个数组，用一个数代替，依次覆盖。





#### 链表总结

- `ListNode head = listNode1;`

- `head = listNode2;   head = listNode2.next;`    这样都不影响`listNode1;`

- `head.next = listNode2;`  这样会影响`listNode1;`

- 两个链表相等了，只要一方不改变next，就互不影响。

  ```java
  public static ListNode reverseList(ListNode head) {
      ListNode result = null;
      while (head != null) {
          ListNode next = head.next;
          head.next = result;
          result = head;
          head = next;
      }
      return result;
  }
  
  
  //////////////////////////////////////
  
  
  public static ListNode reverseList(ListNode head) {
  
      ListNode result = null;
      while (head != null) {
          ListNode curr = head;
          curr.next = result;   // head 立马会发生变化  这是 head.next 也会指向result
          result = curr;
          head = head.next;
      }
      return result;
  }
  ```
  
  









### 第十一天 - 双指针：简单

- 前面的节点到达null时，后面的节点就是倒数第k个

  > [剑指 Offer 18. 删除链表的节点 - 力扣（Leetcode）](https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  // 双指针
  ```

  

- 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

  例如，一个链表有 `6` 个节点，从头节点开始，它们的值依次是 `1、2、3、4、5、6`。这个链表的倒数第 `3` 个节点是值为 `4` 的节点。

  > [剑指 Offer 22. 链表中倒数第k个节点 - 力扣（Leetcode）](https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
  class Solution {
  
      public ListNode getKthFromEnd(ListNode head, int k) {
          ListNode former = head;
          ListNode latter = head;
  
          for (int i = 0; i < k; i++){   // 先让其中一个节点先移动k次。
              former = former.next;   
          }
  
          while(former != null){         // 前面的节点到达null时，后面的节点就是倒数第k个
              former = former.next;
              latter = latter.next;
          }
  
          return latter;
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 

### 第十二天 - 双指针：简单

- 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

  > [剑指 Offer 25. 合并两个排序的链表 - 力扣（Leetcode）](https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
  class Solution {
      
      // 方法一： 递归
       public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  
           if (l1 == null) return l2;
           if (l2 == null) return l1;
           
           // 递归的思想         《有点不太好想》
           if(l1.val <= l2.val) {
               l1.next = mergeTwoLists(l1.next, l2);
               return l1;
           } else {
               l2.next = mergeTwoLists(l1, l2.next);
               return l2;
           }
       }
  
      // 方法二：双指针
      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          
          ListNode result = new ListNode(0);    // 伪头节点
          ListNode curr = result;
  
          while (l1 != null && l2 != null){
              if (l1.val >= l2.val){
                  curr.next = l2;
                  curr = curr.next;
                  l2 = l2.next;
              } else if (l1.val < l2.val) {
                  curr.next = l1;
                  curr = curr.next;
                  l1 = l1.next;
              }
          }
          curr.next = l1 == null ? l2 : l1;
          return result.next;
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 

- 输入两个链表，找出它们的第一个公共节点。

  > [剑指 Offer 22. 链表中倒数第k个节点 - 力扣（Leetcode）](https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) {
   *         val = x;
   *         next = null;
   *     }
   * }
   */
  
  class Solution {
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          ListNode listA = headA;
          ListNode listB = headB;
  
          while(listA != listB){
              // 这里不能写成 listA.next == null
              listA = listA == null ? headB : listA.next;
              listB = listB == null ? headA : listB.next;
          }
          return listA;
          
      }
  }
  ```
  
  > 总结，沉淀：
  >
  > - 使用双指针
  >
  > - // “我走过我的世界，再从你的世界走一遍”
  > - // “你走过你的世界，再从我的世界走一遍”
  > - // “最终我们将相遇，可能在途中（公共节点），可能在结尾（null）”

### 第十三天 - 双指针：简单

- 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。

  > [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 - 力扣（Leetcode）](https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      public int[] exchange(int[] nums) {
          int N = nums.length;
          if(N == 0 || N == 1) return nums;
          int left = 0, right = N- 1;
          while (left < right) {
              // whiwle (left < right && nums[left] % 2 != 0) left++;
              // while (left < right && nums[right] % 2 == 0) right--;
              while (left < right && (nums[left] & 1) == 1) left++;
              while (left < right && (nums[right] & 1) == 0) right--;
              swapArrayElement(nums, left, right);
          }
          return nums;
      }
  
      public void swapArrayElement(int[] arr, int i, int j) {
          if (i == j) return;
          arr[i] = arr[i] ^ arr[j];
          arr[j] = arr[i] ^ arr[j];
          arr[i] = arr[i] ^ arr[j];
      }
  }
  ```

  > 总结，沉淀：
  >
  > - num % 2 == 0  说明num是偶数；等价于<span style = "color:blue; font-weight:bold">位运算</span>：(num & 1) == 0
  > - num % 2 == 1 说明num是奇数；等价于<span style = "color:blue; font-weight:bold">位运算</span>：(num & 1) == 1

- 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

  > [剑指 Offer 57. 和为s的两个数字 - 力扣（Leetcode）](https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  class Solution {
      // 超出时间限制
      // public int[] twoSum(int[] nums, int target) {
      //     int N = nums.length;
      //     for (int i = 0; i < N; i++) {
      //         if (nums[i] <= target) {
      //             for (int j = i + 1; j < N; j++) {
      //                 if(nums[j] == target - nums[i]) return new int[]{nums[i], nums[j]};
      //             }
      //         } 
      //     }
      //     return new int[0];
      // }
  
      public int[] twoSum(int[] nums, int target) {
          int l = 0, h = nums.length -1;
          while (l < h) {
              int sum = nums[l] + nums[h];
              if (sum > target) h--;
              else if (sum < target) l++;
              else return new int[]{nums[l], nums[h]};
          }
          return new int[0];
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 做题思路：
  >
  >   - 从数组两头依次相加，得到 sum = num[l] + num[h]
  >
  >   - 如果 sum > target ，右边的指标左移一位
  >
  >   - 如果 sum < target ，左边的指标右移一位
  >
  >   - 直到 sum > target
  >
  > - 

- 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

  > [剑指 Offer 58 - I. 翻转单词顺序 - 力扣（Leetcode）](https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  // 方法一 ： 纯字符串操作
  class Solution {
      public String reverseWords(String s) {
          // 如果字符串中空格数为x，那么经过split(" ")处理之后，
          // 结果数组中会多出 x-1 个空字符 "" (注意不是空格符，是空字符)
          String[] data = s.trim().split(" ");
          StringBuilder stringBuilder = new StringBuilder();
          for (int i = data.length - 1; i >= 0; i--) {
              if (data[i].equals("")) continue;    // 因此这里遇到空字符，就跳到下一个循环
              stringBuilder.append(data[i] + " ");
          }
          return stringBuilder.toString().trim();
      }
  }
  // 方法二：双指针
  class Solution {
      public String reverseWords(String s) {
          // 删除字符串前后的空格
          String trim = s.trim();
          int length = trim.length();
          StringBuilder result = new StringBuilder();
          int j = length - 1;
          int i = length - 1;
          while (i >= 0){
              // 找到首个空字符，把前面的单词追加到result中
              while (i >= 0 && trim.charAt(i) != ' ') i--;  
              result.append(trim.substring(i + 1, j + 1) + " ");
              // 跳过空字符，到达下一个单词的组后一个字母时，将j = i 记录
              while (i >= 0 && trim.charAt(i) == ' ') i--;
              j = i;
          }
          return result.toString().trim();
      }
  }
  ```

  > 总结，沉淀：
  >
  > - `s.trim().split(" ");`  
  >   - trim() 方法是消除字符串两头的空格字符
  >   - split(" ") 按照空格字符切分字符串，但是要注意：如果字符串中有多个空格字符连着，结果数组中会产生空字符
  > - `trim.charAt(i) != ' '`
  >   - char 类型的字符也可以和 ' ' 比较
  >   - string(i) == " "  与这个相比着理解
  > - `trim.substring(i, j)`
  >   - 获取字符串的子字符串，包前（i）不包后（j）

### 第十四天 -  搜索与回溯算法：中等

- [剑指 Offer 12. 矩阵中的路径 - 力扣（Leetcode）](https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [面试题13. 机器人的运动范围 LCOF - 力扣（Leetcode）](https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第十五天 - 搜索与回溯算法：中等

- [剑指 Offer 34. 二叉树中和为某一值的路径 LCOF - 力扣（Leetcode）](https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 36. 二叉搜索树与双向链表 LCOF - 力扣（Leetcode）](https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

- [剑指 Offer 54. 二叉搜索树的第k大节点 - 力扣（Leetcode）](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第十六天 - 排序：简单

- [面试题45. 把数组排成最小的数 - 力扣（Leetcode）](https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

- 从**若干副扑克牌**中随机抽 `5` 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

  > [面试题61. 扑克牌中的顺子 - 力扣（Leetcode）](https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

  ```java
  // 根据题目要求，数组长度为5
  public boolean isStraight(int[] nums) {
      Set<Integer> set = new HashSet<>();
      int max = 0;
      int min = 15;
      for (int num : nums) {
          if ( num == 0 ) continue;
          // 如果
          if (set.contains(num)) return false;
          else set.add(num);
          max = Math.max(num, max);
          min = Math.min(num, min);
      }
      return max - min < 5;
  }
  
  // 不规定数组个数
  
  public boolean isStraight(int[] nums) {
      //先排序
      selection(nums);
      int count = 0;
      for (int i = 0; i < nums.length - 1; i++) {
          if (nums[i] == 0) {
              count++;  // 计算0的个数
              continue;
          }
          int num = 0;
          // 计算两个元素之间相隔几个数
          if (nums[i + 1]  ==  nums[i]){
              num = 0;  // 如果两个数相等，直接返回false
          } else{
              num = nums[i + 1] - nums[i] - 1;
          }
          count -= num;  // 更新count
      }
  
      if (count >= 0) return true;
      return false;
  }
  
  
  public static void selection(int[] arr) {
      if (arr == null || arr.length < 2) {
          return;
      }
      int N = arr.length;
      for (int i = 0; i < N; i++) {
          int indexMin = i;
          for (int j = i + 1; j < N; j++) {
              indexMin = arr[j] > arr[indexMin] ? indexMin : j;
          }
          if (i == indexMin ) continue;
          arr[i] = arr[i] ^ arr[indexMin];
          arr[indexMin] = arr[i] ^ arr[indexMin];
          arr[i] = arr[i] ^ arr[indexMin];
      }
  }
  ```

  > 总结，沉淀：
  >
  > - 从这个题目中，我知道了，做题要充分利用题干条件。

### 第十七天 - 排序：中等

- 输入整数数组 `arr` ，找出其中最小的 `k` 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

  >  [剑指 Offer 40. 最小的k个数 - 力扣（Leetcode）](https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



- 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

  > [剑指 Offer 41. 数据流中的中位数 - 力扣（Leetcode）](https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)





### 第十八天 - 搜索与回溯算法：中等

- 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

  > [剑指 Offer 55 - I. 二叉树的深度 - 力扣（Leetcode）](https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)





- 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

  > [剑指 Offer 55 - II. 平衡二叉树 - 力扣（Leetcode）](https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)





### 第十九天 - 搜索与回溯算法：中等

- 求 `1+2+...+n` ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

  > [剑指 Offer 64. 求1+2+…+n - 力扣（Leetcode）](https://leetcode.cn/problems/qiu-12n-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)





- 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

  > [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 - 力扣（Leetcode）](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)





- 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

  > [剑指 Offer 68 - II. 二叉树的最近公共祖先 - 力扣（Leetcode）](https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)





###  第二十天 - 分治算法：中等

- [剑指 Offer 07. 重建二叉树 - 力扣（Leetcode）](https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

- [剑指 Offer 16. 数值的整数次方 - 力扣（Leetcode）](https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 33. 二叉搜索树的后序遍历序列 - 力扣（Leetcode）](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

### 第二十一天 - 位运算：简单

- [剑指 Offer 15. 二进制中1的个数 - 力扣（Leetcode）](https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 65. 不用加减乘除做加法 - 力扣（Leetcode）](https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第二十二天 - 位运算：中等

- [剑指 Offer 56 - I. 数组中数字出现的次数 - 力扣（Leetcode）](https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 56 - II. 数组中数字出现的次数 II - 力扣（Leetcode）](https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第二十三天 - 数学：简单

- [剑指 Offer 39. 数组中出现次数超过一半的数字 - 力扣（Leetcode）](https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)

- [剑指 Offer 66. 构建乘积数组 - 力扣（Leetcode）](https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第二十四天 - 数学：中等

- [剑指 Offer 14- I. 剪绳子 - 力扣（Leetcode）](https://leetcode.cn/problems/jian-sheng-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 57 - II. 和为s的连续正数序列 - 力扣（Leetcode）](https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 62. 圆圈中最后剩下的数字 - 力扣（Leetcode）](https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第二十五天 - 模拟：中等

- [剑指 Offer 29. 顺时针打印矩阵 LCOF - 力扣（Leetcode）](https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 31. 栈的压入、弹出序列 - 力扣（Leetcode）](https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第二十六天 - 字符串：中等

- [剑指 Offer 20. 表示数值的字符串 - 力扣（Leetcode）](https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [面试题67. 把字符串转换成整数 - 力扣（Leetcode）](https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第二十七天  -  栈和队列：困难

- [剑指 Offer 59 - I. 滑动窗口的最大值 - 力扣（Leetcode）](https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [面试题59 - II. 队列的最大值 - 力扣（Leetcode）](https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第二十八天 - 搜索与回溯算法：困难

- [剑指 Offer 37. 序列化二叉树 - 力扣（Leetcode）](https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 38. 字符串的排列 LCOF - 力扣（Leetcode）](https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第二十九天 - 动态规划：困难

- [剑指 Offer 19. 正则表达式匹配 - 力扣（Leetcode）](https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 49. 丑数 - 力扣（Leetcode）](https://leetcode.cn/problems/chou-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 60. n个骰子的点数 - 力扣（Leetcode）](https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第三十天 - 分治算法：困难

- [剑指 Offer 17. 打印从1到最大的n位数 - 力扣（Leetcode）](https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 51. 数组中的逆序对 - 力扣（Leetcode）](https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)



### 第三十一天 - 数学：困难

- [剑指 Offer 14- II. 剪绳子 II - 力扣（Leetcode）](https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 43. 1～n 整数中 1 出现的次数 - 力扣（Leetcode）](https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)
- [剑指 Offer 44. 数字序列中某一位的数字 - 力扣（Leetcode）](https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle)





<img src="./images/001.jpg" alt="image" style="zoom:25%;" />

## 专项突破

### 第一天 - 整数

- [剑指 Offer II 001. 整数除法 - 力扣（Leetcode）](https://leetcode.cn/problems/xoh6Oh/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```java
```



- [剑指 Offer II 002. 二进制加法 - 力扣（Leetcode）](https://leetcode.cn/problems/JFETK5/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```
```



- [剑指 Offer II 003. 前 n 个数字二进制中 1 的个数 - 力扣（Leetcode）](https://leetcode.cn/problems/w3tCBm/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```
```





### 第二天 - 整数

- [剑指 Offer II 004. 只出现一次的数字 - 力扣（Leetcode）](https://leetcode.cn/problems/WGki4K/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 005. 单词长度的最大乘积 - 力扣（Leetcode）](https://leetcode.cn/problems/aseY1I/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 006. 排序数组中两个数字之和 - 力扣（Leetcode）](https://leetcode.cn/problems/kLl5u1/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三天 - 数组

- [剑指 Offer II 007. 数组中和为 0 的三个数 - 力扣（Leetcode）](https://leetcode.cn/problems/1fGaJU/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 008. 和大于等于 target 的最短子数组 - 力扣（Leetcode）](https://leetcode.cn/problems/2VG8Kg/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 009. 乘积小于 K 的子数组 - 力扣（Leetcode）](https://leetcode.cn/problems/ZVAVXX/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第四天 - 数组

- [剑指 Offer II 010. 和为 k 的子数组 - 力扣（Leetcode）](https://leetcode.cn/problems/QTMn0o/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 011. 0 和 1 个数相同的子数组 - 力扣（Leetcode）](https://leetcode.cn/problems/A1NYOS/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 012. 左右两边子数组的和相等 - 力扣（Leetcode）](https://leetcode.cn/problems/tvdfij/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 013. 二维子矩阵的和 - 力扣（Leetcode）](https://leetcode.cn/problems/O4NDxx/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第五天 - 字符串

- [剑指 Offer II 014. 字符串中的变位词 - 力扣（Leetcode）](https://leetcode.cn/problems/MPnaiL/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 015. 字符串中的所有变位词 - 力扣（Leetcode）](https://leetcode.cn/problems/VabMRr/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 016. 不含重复字符的最长子字符串 - 力扣（Leetcode）](https://leetcode.cn/problems/wtcaE1/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第六天 - 字符串

- [剑指 Offer II 017. 含有所有字符的最短字符串 - 力扣（Leetcode）](https://leetcode.cn/problems/M1oyTv/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 018. 有效的回文 - 力扣（Leetcode）](https://leetcode.cn/problems/XltzEq/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 019. 最多删除一个字符得到回文 - 力扣（Leetcode）](https://leetcode.cn/problems/RQku0D/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 020. 回文子字符串的个数 - 力扣（Leetcode）](https://leetcode.cn/problems/a7VOhD/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第七天 - 链表

- [剑指 Offer II 021. 删除链表的倒数第 n 个结点 - 力扣（Leetcode）](https://leetcode.cn/problems/SLwz0R/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```java
class Solution {
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
```

> 总结沉淀：
>
> - 在对链表进行操作时，一种常用的技巧是添加一个<span style = "color:blue; font-weight:bold">哑节点（dummy node）</span>，它的 next指针指向链表的头节点。这样一来，我们就不需要对头节点进行特殊的判断了。
> - <span style = "color:blue; font-weight:bold">哑节点（dummy node）</span>的创建要看节点的构造函数是否合适？有的不能创造哑节点。



- [剑指 Offer II 022. 链表中环的入口节点 - 力扣（Leetcode）](https://leetcode.cn/problems/c32eOV/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```java
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
```

> 总结沉淀：
>
> 此类链表题目一般都是使用双指针法解决的，例如<span style = "color:blue; font-weight:bold">寻找距离尾部第 k 个节点</span>、<span style = "color:blue; font-weight:bold">寻找环入口</span>、<span style = "color:blue; font-weight:bold">寻找公共尾部入口</span>等。
>
> - 思路很好，详见：[剑指 Offer II 022. 链表中环的入口节点 - 力扣（Leetcode）](https://leetcode.cn/problems/c32eOV/solutions/977000/jian-zhi-offer-ii-022-lian-biao-zhong-hu-8f1m/)
> - 



- [剑指 Offer II 023. 两个链表的第一个重合节点 - 力扣（Leetcode）](https://leetcode.cn/problems/3u1WK4/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```java
// 双指针
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
```

> 总结沉淀：
>
> - “我走过我的世界，再从你的世界走一遍”
>  * “你走过你的世界，再从我的世界走一遍”
>  * “最终我们将相遇，可能在途中（公共节点），可能在结尾（null）”



### 第八天 - 链表

- [剑指 Offer II 024. 反转链表 - 力扣（Leetcode）](https://leetcode.cn/problems/UHnkqh/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 025. 链表中的两数相加 - 力扣（Leetcode）](https://leetcode.cn/problems/lMSNwu/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 026. 重排链表 - 力扣（Leetcode）](https://leetcode.cn/problems/LGjMqU/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第九天 - 链表

- [剑指 Offer II 027. 回文链表 - 力扣（Leetcode）](https://leetcode.cn/problems/aMhZSa/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 028. 展平多级双向链表 - 力扣（Leetcode）](https://leetcode.cn/problems/Qv1Da2/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 029. 排序的循环链表 - 力扣（Leetcode）](https://leetcode.cn/problems/4ueAj6/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十天 - 哈希表

- [剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器 - 力扣（Leetcode）](https://leetcode.cn/problems/FortPu/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 031. 最近最少使用缓存 - 力扣（Leetcode）](https://leetcode.cn/problems/OrIXps/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 032. 有效的变位词 - 力扣（Leetcode）](https://leetcode.cn/problems/dKk3P7/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十一天 - 哈希表

- [剑指 Offer II 033. 变位词组 - 力扣（Leetcode）](https://leetcode.cn/problems/sfvd7V/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 034. 外星语言是否排序 - 力扣（Leetcode）](https://leetcode.cn/problems/lwyVBB/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 035. 最小时间差 - 力扣（Leetcode）](https://leetcode.cn/problems/569nqc/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十二天 - 栈

- [剑指 Offer II 036. 后缀表达式 - 力扣（Leetcode）](https://leetcode.cn/problems/8Zf90G/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 037. 小行星碰撞 - 力扣（Leetcode）](https://leetcode.cn/problems/XagZNi/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 038. 每日温度 - 力扣（Leetcode）](https://leetcode.cn/problems/iIQa4I/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十三天 - 栈

- [剑指 Offer II 039. 直方图最大矩形面积 - 力扣（Leetcode）](https://leetcode.cn/problems/0ynMMM/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 040. 矩阵中最大的矩形 - 力扣（Leetcode）](https://leetcode.cn/problems/PLYXKQ/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十四天 - 队列

- [剑指 Offer II 041. 滑动窗口的平均值 - 力扣（Leetcode）](https://leetcode.cn/problems/qIsx9U/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 042. 最近请求次数 - 力扣（Leetcode）](https://leetcode.cn/problems/H8086Q/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 043. 往完全二叉树添加节点 - 力扣（Leetcode）](https://leetcode.cn/problems/NaqhDT/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十五天 - 队列

- [剑指 Offer II 044. 二叉树每层的最大值 - 力扣（Leetcode）](https://leetcode.cn/problems/hPov7L/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 045. 二叉树最底层最左边的值 - 力扣（Leetcode）](https://leetcode.cn/problems/LwUNpT/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 046. 二叉树的右侧视图 - 力扣（Leetcode）](https://leetcode.cn/problems/WNC0Lk/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十六天 - 树

- [剑指 Offer II 047. 二叉树剪枝 - 力扣（Leetcode）](https://leetcode.cn/problems/pOCWxh/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return  null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.right == null && root.left == null && root.val == 0) return null;
        
        return root;
        
    }
}
```

> 总结沉淀：
>
> - 

- [剑指 Offer II 048. 序列化与反序列化二叉树 - 力扣（Leetcode）](https://leetcode.cn/problems/h54YBf/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```java
```



- [剑指 Offer II 049. 从根节点到叶节点的路径数字之和 - 力扣（Leetcode）](https://leetcode.cn/problems/3Etpl5/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

```
```





### 第十七天 - 树

- [剑指 Offer II 050. 向下的路径节点之和 - 力扣（Leetcode）](https://leetcode.cn/problems/6eUYwP/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 051. 节点之和最大的路径 - 力扣（Leetcode）](https://leetcode.cn/problems/jC7MId/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 052. 展平二叉搜索树 - 力扣（Leetcode）](https://leetcode.cn/problems/NYBBNL/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十八天 - 树

- [剑指 Offer II 053. 二叉搜索树中的中序后继 - 力扣（Leetcode）](https://leetcode.cn/problems/P5rCT8/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 054. 所有大于等于节点的值之和 - 力扣（Leetcode）](https://leetcode.cn/problems/w6cpku/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 055. 二叉搜索树迭代器 - 力扣（Leetcode）](https://leetcode.cn/problems/kTOapQ/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第十九天 - 树

- [剑指 Offer II 056. 二叉搜索树中两个节点之和 - 力扣（Leetcode）](https://leetcode.cn/problems/opLdQZ/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 057. 值和下标之差都在给定的范围内 - 力扣（Leetcode）](https://leetcode.cn/problems/7WqeDu/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 058. 日程表 - 力扣（Leetcode）](https://leetcode.cn/problems/fi9suh/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十天 - 堆

- [剑指 Offer II 059. 数据流的第 K 大数值 - 力扣（Leetcode）](https://leetcode.cn/problems/jBjn9C/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 060. 出现频率最高的 k 个数字 - 力扣（Leetcode）](https://leetcode.cn/problems/g5c51o/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 061. 和最小的 k 个数对 - 力扣（Leetcode）](https://leetcode.cn/problems/qn8gGX/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十一天 - 前缀树

- [剑指 Offer II 062. 实现前缀树 - 力扣（Leetcode）](https://leetcode.cn/problems/QC3q1f/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 063. 替换单词 - 力扣（Leetcode）](https://leetcode.cn/problems/UhWRSj/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 064. 神奇的字典 - 力扣（Leetcode）](https://leetcode.cn/problems/US1pGT/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十二天 - 前缀树

- [剑指 Offer II 065. 最短的单词编码 - 力扣（Leetcode）](https://leetcode.cn/problems/iSwD2y/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 066. 单词之和 - 力扣（Leetcode）](https://leetcode.cn/problems/z1R5dt/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 067. 最大的异或 - 力扣（Leetcode）](https://leetcode.cn/problems/ms70jA/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十三天 - 二分查找

- [剑指 Offer II 068. 查找插入位置 - 力扣（Leetcode）](https://leetcode.cn/problems/N6YdxV/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 069. 山峰数组的顶部 - 力扣（Leetcode）](https://leetcode.cn/problems/B1IidL/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 070. 排序数组中只出现一次的数字 - 力扣（Leetcode）](https://leetcode.cn/problems/skFtm2/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十四天 - 二分查找

- [剑指 Offer II 071. 按权重生成随机数 - 力扣（Leetcode）](https://leetcode.cn/problems/cuyjEf/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 072. 求平方根 - 力扣（Leetcode）](https://leetcode.cn/problems/jJ0w9p/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 073. 狒狒吃香蕉 - 力扣（Leetcode）](https://leetcode.cn/problems/nZZqjQ/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十五天 - 排序

- [剑指 Offer II 074. 合并区间 - 力扣（Leetcode）](https://leetcode.cn/problems/SsGoHC/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 075. 数组相对排序 - 力扣（Leetcode）](https://leetcode.cn/problems/0H97ZC/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十六天 - 排序

- [剑指 Offer II 076. 数组中的第 k 大的数字 - 力扣（Leetcode）](https://leetcode.cn/problems/xx4gT2/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 077. 链表排序 - 力扣（Leetcode）](https://leetcode.cn/problems/7WHec2/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 078. 合并排序链表 - 力扣（Leetcode）](https://leetcode.cn/problems/vvXgSW/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十七天 - 回溯

- [剑指 Offer II 079. 所有子集 - 力扣（Leetcode）](https://leetcode.cn/problems/TVdhkn/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 080. 含有 k 个元素的组合 - 力扣（Leetcode）](https://leetcode.cn/problems/uUsW3B/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 081. 允许重复选择元素的组合 - 力扣（Leetcode）](https://leetcode.cn/problems/Ygoe9J/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第二十八天 - 回溯

- [剑指 Offer II 082. 含有重复元素集合的组合 - 力扣（Leetcode）](https://leetcode.cn/problems/4sjJUc/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)

- [剑指 Offer II 083. 没有重复元素集合的全排列 - 力扣（Leetcode）](https://leetcode.cn/problems/VvJkup/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 084. 含有重复元素集合的全排列 - 力扣（Leetcode）](https://leetcode.cn/problems/7p8L0Z/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



###  第二十九天 - 回溯

- [剑指 Offer II 085. 生成匹配的括号 - 力扣（Leetcode）](https://leetcode.cn/problems/IDBivT/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 086. 分割回文子字符串 - 力扣（Leetcode）](https://leetcode.cn/problems/M99OJA/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 087. 复原 IP - 力扣（Leetcode）](https://leetcode.cn/problems/0on3uN/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十天 - 动态规划

- [剑指 Offer II 088. 爬楼梯的最少成本 - 力扣（Leetcode）](https://leetcode.cn/problems/GzCJIP/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 089. 房屋偷盗 - 力扣（Leetcode）](https://leetcode.cn/problems/Gu0c2T/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 090. 环形房屋偷盗 - 力扣（Leetcode）](https://leetcode.cn/problems/PzWKhm/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十一天 - 动态规划

- [剑指 Offer II 091. 粉刷房子 - 力扣（Leetcode）](https://leetcode.cn/problems/JEj789/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 092. 翻转字符 - 力扣（Leetcode）](https://leetcode.cn/problems/cyJERH/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 093. 最长斐波那契数列 - 力扣（Leetcode）](https://leetcode.cn/problems/Q91FMA/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十二天 - 动态规划

- [剑指 Offer II 094. 最少回文分割 - 力扣（Leetcode）](https://leetcode.cn/problems/omKAoA/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 095. 最长公共子序列 - 力扣（Leetcode）](https://leetcode.cn/problems/qJnOS7/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 096. 字符串交织 - 力扣（Leetcode）](https://leetcode.cn/problems/IY6buf/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十三天 - 动态规划

- [剑指 Offer II 097. 子序列的数目 - 力扣（Leetcode）](https://leetcode.cn/problems/21dk04/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 098. 路径的数目 - 力扣（Leetcode）](https://leetcode.cn/problems/2AoeFn/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 099. 最小路径之和 - 力扣（Leetcode）](https://leetcode.cn/problems/0i0mDW/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十四天 - 动态规划

- [剑指 Offer II 100. 三角形中最小路径之和 - 力扣（Leetcode）](https://leetcode.cn/problems/IlPe0q/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 101. 分割等和子集 - 力扣（Leetcode）](https://leetcode.cn/problems/NUPfPr/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 102. 加减的目标值 - 力扣（Leetcode）](https://leetcode.cn/problems/YaVDxD/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十五天 - 动态规划

- [剑指 Offer II 103. 最少的硬币数目 - 力扣（Leetcode）](https://leetcode.cn/problems/gaM7Ch/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 104. 排列的数目 - 力扣（Leetcode）](https://leetcode.cn/problems/D0F0SV/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十六天 - 图

- [剑指 Offer II 105. 岛屿的最大面积 - 力扣（Leetcode）](https://leetcode.cn/problems/ZL6zAn/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 106. 二分图 - 力扣（Leetcode）](https://leetcode.cn/problems/vEAB3K/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 107. 矩阵中的距离 - 力扣（Leetcode）](https://leetcode.cn/problems/2bCMpM/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十七天 - 图

- [剑指 Offer II 108. 单词演变 - 力扣（Leetcode）](https://leetcode.cn/problems/om3reC/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 109. 开密码锁 - 力扣（Leetcode）](https://leetcode.cn/problems/zlDJc7/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 110. 所有路径 - 力扣（Leetcode）](https://leetcode.cn/problems/bP4bmD/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十八天 - 图

- [剑指 Offer II 111. 计算除法 - 力扣（Leetcode）](https://leetcode.cn/problems/vlzXQL/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 112. 最长递增路径 - 力扣（Leetcode）](https://leetcode.cn/problems/fpTFWP/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)
- [剑指 Offer II 113. 课程顺序 - 力扣（Leetcode）](https://leetcode.cn/problems/QA2IGt/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117)



### 第三十九天 - 图

- [剑指 Offer II 114. 外星文字典 - 力扣（Leetcode）](https://leetcode.cn/problems/Jf1JuT/?envType=study-plan-v2&id=coding-interviews-special)
- [剑指 Offer II 115. 重建序列 - 力扣（Leetcode）](https://leetcode.cn/problems/ur2n8P/?envType=study-plan-v2&id=coding-interviews-special)
- [剑指 Offer II 116. 省份数量 - 力扣（Leetcode）](https://leetcode.cn/problems/bLyHh0/?envType=study-plan-v2&id=coding-interviews-special)





### 第四十天 - 图

- [剑指 Offer II 117. 相似的字符串 - 力扣（Leetcode）](https://leetcode.cn/problems/H6lPxb/?envType=study-plan-v2&id=coding-interviews-special)
- [剑指 Offer II 118. 多余的边 - 力扣（Leetcode）](https://leetcode.cn/problems/7LpjUW/?envType=study-plan-v2&id=coding-interviews-special)
- [剑指 Offer II 119. 最长连续序列 - 力扣（Leetcode）](https://leetcode.cn/problems/WhsWhI/?envType=study-plan-v2&id=coding-interviews-special)















