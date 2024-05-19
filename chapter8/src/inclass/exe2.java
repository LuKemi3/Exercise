package inclass;

import java.util.Arrays;

public class exe2 {
    public static void main(String[] args) {
        int[][] array = {
                {5, 3, 8, 1},
                {7, 2},
                {4, 6, 9}
        };

        for (int i = 0; i < array.length; i++) {
            Arrays.sort(array[i]); // 先升序排序
            reverse(array[i]); // 然后反转为降序
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    private static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
