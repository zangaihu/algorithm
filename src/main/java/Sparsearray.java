/**
 * 稀疏数组 第一行记录二维数组的大小以及非零元素个数 其余行记录[行][列][值]
 *
 * @author sunhu
 * @date 2020/11/9 18:36
 */
public class Sparsearray {

    public static void main(String[] args) {

        // 创建二维数组
        int[][] arr = new int[5][5];
        arr[0][2] = 1;
        arr[3][4] = 2;
        // 二维数组遍历
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println("");
        }
        int sum = 0;
        for (int[] row : arr) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.printf("二维数组共有：%d个元素", sum);

        int[][] sparseArray = new int[sum + 1][3];
        // 第一行记录二维数组大小，以及元素个数
        sparseArray[0][0] = arr.length;
        sparseArray[0][1] = arr[0].length;
        sparseArray[0][2] = sum;

        int rowIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    rowIndex++;
                    sparseArray[rowIndex][0] = i;
                    sparseArray[rowIndex][1] = j;
                    sparseArray[rowIndex][2] = arr[i][j];

                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("稀疏数组为：");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        // 根据稀疏数组 构造出二维数组
        int[][] newArr = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            newArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] row : newArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println("");
        }

    }

}
