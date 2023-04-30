

# 面试宝典

## 01-10

- [面试题 01.01. 判定字符是否唯一 - 力扣（Leetcode）](https://leetcode.cn/problems/is-unique-lcci/description/?favorite=xb9lfcwi)

  > 实现一个算法，确定一个字符串 `s` 的所有字符是否全都不同。


```java
class Solution {
    public boolean isUnique(String astr) {
        // 位运算
        int mark = 0;

        for (char c : astr.toCharArray()) {
            int dis = c - 'a';
            if ((mark & (1 << dis)) != 0) return false;
            else mark = mark | (1 << dis);
        }
        return true;
    }
}
```

> 总结，沉淀：
>
> - 做题思路
>   - 首先定义一个整数mark=0，备用
>   - 遍历字符串每个字符，
>   - 循环体中，计算每个字符和'a'的距离，然后用位运算进行存储计算。
>   - 此时，mark的每一个比特位记录的是字符是否出现，出现过是1，未出现过是0，（靠位运算实现）

- 











