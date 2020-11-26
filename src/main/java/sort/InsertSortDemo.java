package sort;

import java.util.Arrays;

/**
 * @author sunhu
 * @date 2020/11/26 11:01
 */
public class InsertSortDemo {
    public static void main(String[] args) {

        int[] arr = new int[] {1, 4, -1, -5, 56, 12, 34};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {

        if (arr.length <= 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            // 待插入数
            int insertVal = arr[i];
            // 前一个位置的index
            int insertIndex = i - 1;

            // 待插入数比前一个小，前一个数后移，知道前面的数比插入数大
            while (insertIndex >= 0 && insertVal > arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 插入位置不是当前位置，插入
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }

    }
}
