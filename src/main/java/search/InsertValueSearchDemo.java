package search;

/**
 * 插值查找
 * 
 * @author sunhu
 * @date 2020/11/27 10:28
 */
public class InsertValueSearchDemo {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 5, 6, 7, 8, 24, 45, 78, 99};
        int index = insertValueSearch(arr, 0, arr.length - 1, 99);
        System.out.println("位置为:" + index);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[0] || value > arr[right]) {
            return -1;
        }

        // 与二分查找 求mid方式不同
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (value > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }

    }
}
