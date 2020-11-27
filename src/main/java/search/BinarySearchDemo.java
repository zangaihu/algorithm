package search;

/**
 * 二分查找(查找数组必须有序)
 * 
 * @author sunhu
 * @date 2020/11/27 10:14
 */
public class BinarySearchDemo {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 5, 6, 7, 8, 24, 45, 78, 99};
        int index = binarySearch(arr, 0, arr.length - 1, 99);
        System.out.println("位置为:" + index);
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (value > arr[mid]) {
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return binarySearch(arr, 0, mid - 1, value);
        } else {
            return mid;
        }

    }
}
