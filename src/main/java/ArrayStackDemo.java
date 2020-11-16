import java.util.Scanner;

/**
 * 数组模拟栈
 * 
 * @author sunhu
 * @date 2020/11/16 18:25
 */
public class ArrayStackDemo {

    public static void main(String[] args) {

        // 测试
        // 创建一个ArryStack的对象
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;

        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show：显示栈");
            System.out.println("exit：退出栈");
            System.out.println("push：入栈");
            System.out.println("pop：出栈");
            System.out.println("请输入你的选择：");

            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是：%d：\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;

            }
        }

        System.out.println("程序退出！");

    }

}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    ArrayStack(int size) {
        maxSize = size;
        stack = new int[size];
    }

    /**
     * 判断是否满
     * 
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断是否空
     * 
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈 top++ stack[pop]=element
     * 
     * @param element
     */
    public void push(int element) {
        if (isFull()) {
            System.out.println("已满");
            return;
        }
        top++;
        stack[top] = element;
    }

    /**
     * 出栈 element=stack[top] top--
     * 
     * @return
     */
    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("空");
        }
        return stack[top--];

    }

    public void list() {
        if (isEmpty()) {
            System.out.printf("栈空，没有数据！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}