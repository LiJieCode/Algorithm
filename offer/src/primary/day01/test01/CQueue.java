package primary.day01.test01;

/**
 * 题目地址：
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bfoimle
 *
 * 题目内容：
 * 用两个栈实现一个队列。队列的声明如下：请实现它的两个函数 appendTail 和 deleteHead，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */

import java.util.LinkedList;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
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
