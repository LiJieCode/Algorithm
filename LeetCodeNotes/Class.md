# 分类刷题

- [Leetcode面试高频题分类刷题总结 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/349940945)
- [LeetCode 刷题顺序，按标签分类，科学刷题！ - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/501483324)
- [LeetCode 题目分类（持续更新中...） - 哔哩哔哩 (bilibili.com)](https://www.bilibili.com/read/cv15395653/)





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

> 总结，沉淀：

- 





## 二分查找







## 动态规划

> 动态规划无疑是很重要的一个算法，一定要学好，用好，领会好。

- 【70. 爬楼梯】  -  简单

  [70. 爬楼梯 - 力扣（Leetcode）](https://leetcode.cn/problems/climbing-stairs/)

```JAVA
public class Solution {
    // 动态规划
    public int climbStairs(int n) {
        int preLast = 0, last = 0, curr = 1;
        for (int i = 0; i <= n; i++) {
            preLast = last;
            last = curr;
            curr = preLast + last;
        }
        return curr;
    }

    // 第二种动态规划
    public int climbStairs1(int n) {
        if (n == 1 || n == 2) return n;
        int preLast = 1, last = 2, curr = 3;
        for (int i = 4; i <= n; i++) {
            preLast = last;
            last = curr;
            curr = preLast + last;
        }
        return curr;
    }

    // 最后给个递归的方法
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) return n;
        // 递归的思想在这
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }
}
```

- 【112路径总和】- 和二叉树有关，要会深度优先和广度优先搜索

  [112. 路径总和 - 力扣（Leetcode）](https://leetcode.cn/problems/path-sum/)

```java
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        nodeQueue.add(root);
        valueQueue.add(root.val);

        while (!nodeQueue.isEmpty()){
            // 取出当前节点和值
            TreeNode currNode = nodeQueue.poll();
            int currValue = valueQueue.poll();
            // 判断是否是叶子节点
            if (currNode.left == null && currNode.right == null) {
                // 判断和是否与目标值相等
                if (currValue == targetSum) return true;
            }

            // 更新当前节点
            if (currNode.left != null) {
                nodeQueue.add(currNode.left);
                valueQueue.add(currNode.left.val + currValue);
            }
            // 更新当前值
            if (currNode.right != null) {
                nodeQueue.add(currNode.right);
                valueQueue.add(currNode.right.val + currValue);
            }
        }
        return false;
    }
}
```

> 总结，沉淀：
>
> - 

- 【113路径总和2】 - 还没做

  [113. 路径总和 II - 力扣（Leetcode）](https://leetcode.cn/problems/path-sum-ii/)

```java
```



- 【62不同路径】 -   网格无障碍  -  简单

  [62. 不同路径 - 力扣（Leetcode）](https://leetcode.cn/problems/unique-paths/)

```java
public class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] +  dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

- 【63不同路径】 -   网格有障碍  -  中等

  [63. 不同路径 II - 力扣（Leetcode）](https://leetcode.cn/problems/unique-paths-ii/)

```java
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            //
            if (obstacleGrid[i][0] == 1) break;   // 后面的网格都是0
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            //
            if (obstacleGrid[0][i] == 1) break;   // 后面的网格都是0
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 跳过，也就意味着这个网格的值为0
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

> 总结，沉淀：
>
> - 

- 【64最小路径和】

  [64. 最小路径和 - 力扣（Leetcode）](https://leetcode.cn/problems/minimum-path-sum/)

```java
public class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
```

- 【198打家劫舍】 

  [198. 打家劫舍 - 力扣（Leetcode）](https://leetcode.cn/problems/house-robber/)

```java
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // 数组长度大于1，就要提前更新1位置的数组，后面循环中会用到
        if (n > 1) nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // 这里有个两种情况：
            // 你偷 "当前位置的钱"，就只能再偷 "当前位置-2的位置的钱"
            // 或者，你不偷 "当前位置的钱"，那就只能偷 "当前位置-1的位置的钱"
            // 两种情况选择做大值，即可。
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }
        return nums[n - 1];
    }
}
```

- 【213打家劫舍2】

  [213. 打家劫舍 II - 力扣（Leetcode）](https://leetcode.cn/problems/house-robber-ii/)

```java
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        // 分两种情况讨论
        // 第一种：不偷第一个
        // 第二种：不偷最后一个
        // 然后分别用打家劫舍1的代码解决问题即可
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    // 这里就是打家劫舍1 的解题方案嘛。
    public int myRob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n > 1) nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return nums[n - 1];
    }
}
```

> 总结，沉淀：
>
> - 





## 二叉树

> 二叉树的广度优先和深度优先搜索一点要会，然后再掌握几个其他的知识点，包括：二叉树深度，二叉树宽度，判断是否是对称二叉树等等就行了。

- 广度优先搜索  BFS 

```java
public class BFS {

    public int[] treePrintBFS(TreeNode root) {

        if (root == null) return new int[0];
		// 创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        queue.add(root);

        // !queue.isEmpty()
        while (queue.size() != 0) {
            TreeNode curr = queue.poll();
            temp.add(curr.val);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
		// 将ArrayList的数据赋值到数组中
        int size = temp.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    // 以List集合返回 层先方法
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)  return  res;
		// 创建一个队列
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()) {
            // 每一层数据保存在一个ArrayList中
            ArrayList<Integer> ans = new ArrayList<>();
            // 
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode curr = nodeQueue.poll();
                ans.add(curr.val);
                if (curr.left != null) nodeQueue.add(curr.left);
                if (curr.right != null) nodeQueue.add(curr.right);
            }
            // 每一层的节点数据，增加到List列表中
            res.add(ans);
        }
        return res;
    }
}
```

> 总结，沉淀：
>
> - 广度优先借助 "队列" 实现。

- 深度优先搜索

```java
public class DFS {

    // 先序遍历
    public int[] preorderTraversal(TreeNode root) {
        if (root == null) return new int[0];
		// 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
		// 将ArrayList的数据赋值到数组中
        int size = temp.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }


    // 中序遍历
    public int[] inorderTraversal(TreeNode root) {
        if (root == null) return new int[0];

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        // 当前节点为root
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 如果当前节点不为空，直接入栈
            // 当前节点等于左节点
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            } else { 
                // 当前节点为空了，就把栈顶元素弹出
                // 当前节点等于右节点
                curr = stack.pop();
                // stack.pop();
                temp.add(curr.val);
                curr = curr.right;
            }
        }

        int size = temp.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp.get(i);
        }
        return result;

    }


    // 后序遍历
    public int[] postorderTraversal(TreeNode root) {
        if (root == null) return new int[0];

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.add(node.val);
            // 和前序遍历调换了以下左右子树
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);

        }
		// 这里要反向赋值给数组
        int size = temp.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp.get(size - i - 1);
        }
        return result;
    }
}
```

> 总结，沉淀：
>
> - 深度优先借助 "栈" 实现。
> - 深度优先包括：先序遍历、中序遍历以及后序遍历
>  - 先序遍历很好理解
>  - 中序遍历
>    - 保存一个当前节点
>    - 当前节点不为空就压栈
>    - 当前节点为空就弹栈
>  - 后序遍历是在先序遍历的基础上，加以修改
>    - 先序遍历是：中左右
>    - 调换一下顺序：中右左（这个很容易实现）
>    - 然后反转数组：左右中（这正是后序遍历的顺序）

- 二叉树的最大深度

```java
package tree.depth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目地址：
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * 题目内容：
 * 二叉树的最大深度
 */
public class Solution {

    // 深度优先  -  迭代法
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    // 广度优先  -  借助队列实现
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int res = 0;
        while (!nodeQueue.isEmpty()) {
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);
            }
            res++;
        }
        return res;
    }
}
```

- 满二叉树的最大宽度

```java
```





- 判断一个二叉树是否是对称的二叉树

```java

```







## 回溯算法

> 回溯算法考的好像不太多，所以会几个典型的问题，知道算法的核心思想就好了。

- 全排列问题(不包含重复值)

```java
package backTracking.test01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目地址：
 * https://leetcode.cn/problems/permutations/?envType=study-plan-v2&id=top-100-liked
 *
 * 题目内容：
 * 【46. 全排列】
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 解题思路：
 * 回溯算法
 *
 */

public class Solution {
    public List<List<Integer>> permute(int[] nums) {

        // 结果
        List<List<Integer>> result = new ArrayList<>();
        // 中间结果
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtracking(n, output, result, 0);
        return result;
    }

    public void backtracking(int n, 
                             List<Integer> output, 
                             List<List<Integer>> result, 
                             int first){
        // 终止条件
        if (first == n){
            result.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 交换
            Collections.swap(output, first, i);
            // 下一层
            backtracking(n, output, result, first + 1);
            // 撤销，再交换回来
            Collections.swap(output, first, i);
        }
    }
}
```

- 全排列问题(包含和不包含重复值)

```java
package backTracking.quanpailie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法，数组的全排序46/47
 *
 * 无重复值 和 有重复值
 *
 */

public class Solution {

    boolean vis[];
    // 无重复值
    public List<List<Integer>> permute(int[] nums) {
        // 创建结果链表和中间结果链表
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> output = new ArrayList<>();

        int n = nums.length;
        vis = new boolean[n];

        backtracking1(nums, n, res, output, 0);
        return res;
    }

    public void backtracking1(int[] nums, int n,
                              List<List<Integer>> res,
                              List<Integer> output, int depth){
        // 终止条件
        if (depth == n) {
            res.add(new ArrayList<>(output));
            return;
        }

        //
        for (int i = 0; i < n; i++) {
            // 如果是true，证明已经选过了，直接跳过。
            if (vis[i])  continue;

            // 添加并标记为true
            output.add(nums[i]);
            vis[i] = true;

            backtracking1(nums, n, res, output, depth + 1);
            // 撤销，标记为false
            vis[i] = false;
            output.remove(output.size() - 1);
        }
    }

    /***************************************************************************************
     */

    // 有重复值
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 创建结果链表和中间结果链表
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> output = new ArrayList<>();

        int n = nums.length;
        vis = new boolean[n];
        Arrays.sort(nums);     // 多了一个排序

        backtracking2(nums, n, res, output, 0);
        return res;
    }

    public void backtracking2(int[] nums, int n,
                              List<List<Integer>> res,
                              List<Integer> output, int depth){
        // 终止条件
        if (depth == n) {
            res.add(new ArrayList<>(output));
            return;
        }

        //
        for (int i = 0; i < n; i++) {
            // 剪枝         这里的剪枝条件还不是很理解
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]))  continue;

            // 添加并标记为true
            output.add(nums[i]);
            vis[i] = true;

            backtracking2(nums, n, res, output, depth + 1);
            // 撤销，标记为false
            vis[i] = false;
            output.remove(output.size() - 1);
        }
    }
}
```

> 总结，沉淀：
>
> - 重复值和不重复值的区别，在于剪枝条件不一样
>   - `if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]))  continue;`
>   - `if (vis[i])  continue;`
> - 还有一个区别是，有重复值要提前排序。

- 组合问题









## 贪心算法

> 思想就是用尝试用局部最优来找到最终的全局最优，不要控制，不太好确定是否可以用贪心算法做，先不学了吧。



## 





