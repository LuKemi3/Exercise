package inclass;

import java.util.Arrays;

//
public class exe5 {
    public static void main(String[] args) {
        // 定义一个3*4的二维数组
        int[][] array = {
                {7, 1, 6, 6},
                {8, 5, 7, 3},
                {1, 2, 2, 7}
        };

        // 将二维数组展平为一维数组
        int[] flatArray = new int[array.length * array[0].length];
        int index = 0;
        for (int[] row : array) {
            for (int num : row) {
                flatArray[index++] = num;
            }
        }

        // 对一维数组进行排序
        Arrays.sort(flatArray);

        // 将排序后的元素重新填回二维数组
        index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = flatArray[index++];
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
