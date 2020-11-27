package search;

import java.util.Arrays;

/**
 * 斐波那契查找 是数组长度 接近F[k]-1
 * 
 * @author sunhu
 * @date 2020/11/27 10:40
 */
public class FibonacciSearchDemo {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 4, 5, 6, 8, 9, 45, 67, 87};

        int i = fibonacciSearch(arr, 6);
        System.out.println("位置： " + i);
    }

    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibonacciSearch(int[] arr, int keyValue) {

        int left = 0;
        int right = arr.length - 1;
        int k = 0;
        int[] f = fib();
        int mid = 0;

        while (right > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        while (left < right) {
            // mid 等于数列
            mid = left + f[k - 1] - 1;
            if (keyValue < temp[mid]) {
                right = mid - 1;
                k--;
            } else if (keyValue > temp[mid]) {
                left = mid + 1;
                k -= 2;
            } else {
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }

            }

        }
        return -1;
    }

}
