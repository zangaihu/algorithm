package sort;

import java.util.Arrays;

/**
 * @author sunhu
 * @date 2020/11/26 16:13
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, -1, -5, 56, 12, 34};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {

            while (arr[l] > pivot) {
                l++;
            }
            while (arr[r] < pivot) {
                r--;
            }

            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后发现arr[l] == piovt，r--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            // 如果交换完后发现arr[r] == piovt,l++，后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果l == r，必须让l++,r--,否则出现栈溢出
        if (l == r) {
            l++;
            r--;
        }

        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
