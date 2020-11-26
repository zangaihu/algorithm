package sort;

import java.util.Arrays;

/**
 * @author sunhu
 * @date 2020/11/26 10:38
 */
public class SelectSortDemo {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 4, -1, -5, 56, 12, 34};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr) {
        if (arr.length <= 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // 先确定最小的索引
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // index发生gaibian
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;

            }
        }
    }

}
