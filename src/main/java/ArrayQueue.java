import java.util.Scanner;

/**
 * @author sunhu
 * @date 2020/11/9 19:31
 */
public class ArrayQueue {

    static class ArrayQueue1 {
        private int maxSize;
        private int font;
        private int rear;
        private int[] arr;

        ArrayQueue1(int arrMaxSize) {
            maxSize = arrMaxSize;
            font = -1;
            rear = -1;
            arr = new int[arrMaxSize];
        }

        // isFull
        public Boolean isFull() {
            return rear == maxSize - 1;
        }

        // isEmpty
        public Boolean isEmpty() {
            return rear == font;
        }

        // 进队列
        public void addElement(int n) {
            if (isFull()) {
                System.out.println("队列已满！");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        // 出队列
        public Integer getElement() {
            if (isEmpty()) {
                System.out.println("队列无数据！");
                return null;
            }
            font++;
            int data = arr[font];
            arr[font] = 0;
            return data;
        }

        // 查看队列数据
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列无数据！");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
                System.out.println("");
            }
        }

        public Integer headQueue() {
            // 判断是否为空
            if (isEmpty()) {
                System.out.println("队列空，没有数据！");
                return null;

            }
            return arr[font + 1];
        }

    }

    public static void main(String[] args) {
        ArrayQueue1 aq = new ArrayQueue1(4);
        char key = ' ';// 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出程序");
            System.out.println("h(head):查看队列头部数据");

            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    aq.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字：");
                    int value = scanner.nextInt();
                    aq.addElement(value);
                    break;
                case 'g':// 取出数据
                    try {
                        int res = aq.getElement();
                        System.out.printf("取出的数据为：%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = aq.headQueue();
                        System.out.printf("队列头的数据为：%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");

    }

}
