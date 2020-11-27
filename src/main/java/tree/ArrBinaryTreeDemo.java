package tree;

/**
 * 前序遍历数组（顺序二叉树）
 * 
 * @author sunhu
 * @date 2020/11/27 15:43
 */
public class ArrBinaryTreeDemo {

    // 顺序二叉树的存储 </t>
    // * 1.顺序二叉树通常只考虑完全二叉树
    // * 2.第n个元素的左子节点为 2 * n + 1，
    // * 3.第n个元素的右子节点为 2 * n + 2，
    // * 4.第n个元素的父节点为 (n-1) / 2，
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }

    static class ArrBinaryTree {
        private int[] arr;

        public ArrBinaryTree(int[] arr) {
            this.arr = arr;
        }

        public void preOrder() {
            this.preOrder(0);
        }

        public void preOrder(int index) {
            if (arr == null || arr.length == 0) {
                System.out.println("数组空");
            }
            System.out.printf(arr[index] + "\t");
            // 左子树前序遍历
            if (index * 2 + 1 < arr.length) {
                preOrder(index * 2 + 1);
            }
            // 右子树前序遍历
            if (index * 2 + 2 < arr.length) {
                preOrder(index * 2 + 2);
            }

        }
    }
}
