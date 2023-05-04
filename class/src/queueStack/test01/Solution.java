package queueStack.test01;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目地址：
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * 题目内容：
 * 【有效的括号】
 *
 */
public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) return false;

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('}', '{');
        pairs.put(']', '[');
        pairs.put(')', '(');

        // 借助栈实现
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                // 如果栈为空了，或者栈顶元素和当前元素不匹配，则返回false
                if (charStack.isEmpty() || charStack.peek() != pairs.get(c)) return false;
                charStack.pop();
            } else charStack.push(c);
        }
        // 防止只有左括号
        // 只有左括号的话，栈不为空，就返回false
        return charStack.isEmpty();
    }
}
