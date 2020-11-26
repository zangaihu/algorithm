package sort;

import java.util.Arrays;

/**
 * @author sunhu
 * @date 2020/11/18 18:53
 */
public class BubbleSortDemo {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 4, -1, -5, 56, 12, 34};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr) {

        if (arr.length <= 0) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

}
