package senior.day01.test02;

/**
 *
 * 题目地址：
 * https://leetcode.cn/problems/JFETK5/description/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117
 *
 * 题目：剑指 Offer II 002. 二进制加法
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 */

public class Solution {
    public String addBinary(String a, String b) {
        // 用来存储每一位的计算结果
        StringBuilder builder = new StringBuilder();

        // 找出最大的位数
        int n = Math.max(a.length(), b.length());
        // 保存进位信息
        int carry = 0;

        // 循环每一位，进行计算
        for (int i = 0; i < n; i++) {
            // carry + a
            carry += a.length() - 1 - i >= 0 ? a.charAt(a.length() - 1 - i) - '0' : 0;
            // carry + b
            carry += b.length() - 1 - i >= 0 ? b.charAt(b.length() - 1 - i) - '0' : 0;
            //
            builder.append(carry / 2);
            // 进位信息依旧保存在carry中
            carry = carry % 2;
        }

        // 如果计算完之后，进位信息carry还有值，则直接放在最高位
        if (carry > 0) builder.append(1);
        // 反转字符串
        StringBuilder reverse = builder.reverse();
        return reverse.toString();
    }
    /** 总结沉淀
     * 1、代码：carry += a.length() - 1 - i >= 0 ? a.charAt(a.length() - 1 - i) - '0' : 0;
     *  在混合运算中 byte、short、char 之间不会相互转换，会自动转为int类型去运算。 byte、short、char ->int
     *  其他类型的运算：范围小的数据类型会自动转为大的数据类型去运算。              int -> long ->float ->double
     *  所以这里(a.charAt(a.length() - 1 - i) - '0')，要先减去'0'的值，才能做运算。
     *
     */
}
