package leetcode.stack;

import java.util.Stack;

/**
 * @author sunhu
 * @date 2021/4/30 11:07
 */
public class Stack155 {
    static class MinStack {

        // 辅助栈
        private Stack<Integer> data;
        private Stack<Integer> helper;

        // 数组栈
        // private Stack<int[]> arrayStack;

        /** initialize your data structure here. */
        public MinStack() {
            this.data = new Stack();
            this.helper = new Stack();
        }

        public void push(int val) {

            data.push(val);
            // 压入的值小于辅助栈的值，压入
            if (helper.isEmpty() || helper.peek() >= val) {
                helper.push(val);
            } else {
                // 压入的值大于目前最小值，最小值填充
                helper.push(helper.peek());
            }

        }

        public void pop() {
            if (!data.isEmpty()) {
                data.pop();
                helper.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return helper.peek();
        }
    }

    static class MinStack1 {

        // 数组栈
        private Stack<int[]> arrayStack;

        /** initialize your data structure here. */
        public MinStack1() {
            this.arrayStack = new Stack<>();
        }

        public void push(int val) {
            if (arrayStack.isEmpty()) {
                arrayStack.push(new int[] {val, val});
            } else {
                arrayStack.push(new int[] {val, Math.min(arrayStack.peek()[1], val)});
            }
        }

        public void pop() {
            arrayStack.pop();
        }

        public int top() {
            return arrayStack.peek()[0];
        }

        public int getMin() {
            return arrayStack.peek()[1];
        }
    }

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(5);
        minStack.push(4);
        minStack.push(1);
        minStack.push(9);
        minStack.push(-1);
    }
}
