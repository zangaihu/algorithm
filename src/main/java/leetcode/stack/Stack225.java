package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunhu
 * @date 2021/4/30 13:46
 */
public class Stack225 {

    /*
    请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
    
    实现 MyStack 类：
    
    void push(int x) 将元素 x 压入栈顶。
    int pop() 移除并返回栈顶元素。
    int top() 返回栈顶元素。
    boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     
    
    注意：
    
    你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
    你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
    
     */

    /*
        queue.poll() 删除队列头，并返回
        queue.peek() 取队列头元素
        queue.offer() 向队列尾部加入元素
    
     */

    static class MyStack {

        private Queue<Integer> queue1; // 2 1
        private Queue<Integer> queue2; // 3 2 1

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {

            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }

            Queue tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue1.poll();

        }

        /** Get the top element. */
        public int top() {
            return queue1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
    }
}
