package inclass;

import java.util.Arrays;

public class exe3 {
    public static void main(String[] args) {
        // 定义一个4*5的二维数组
        int[][] array = {
                {3, 5, 2, 8, 6},
                {7, 1, 4, 9, 3},
                {2, 6, 3, 5, 7},
                {8, 3, 6, 1, 4}
        };

        // 存储每行最大值的数组
        int[] maxValues = new int[array.length];

        // 遍历二维数组找到每行的最大值
        for (int i = 0; i < array.length; i++) {
            int max = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
            maxValues[i] = max;
        }

        // 打印最大值数组
        System.out.println("每行的最大值数组: " + Arrays.toString(maxValues));
    }
}
