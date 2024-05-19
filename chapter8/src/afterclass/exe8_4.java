package afterclass;

import java.util.Arrays;
import java.util.Comparator;

public class exe8_4 {
    public static void main(String[] args) {
        // 定义一个8x7的二维数组来表示表格
        int[][] workHours = {
                {2, 4, 3, 4, 5, 8, 8}, // Employee 0
                {7, 3, 4, 3, 3, 4, 4}, // Employee 1
                {3, 3, 4, 3, 3, 2, 2}, // Employee 2
                {9, 3, 4, 7, 3, 4, 1}, // Employee 3
                {3, 5, 4, 3, 6, 3, 8}, // Employee 4
                {3, 4, 4, 6, 3, 4, 4}, // Employee 5
                {3, 7, 4, 8, 3, 8, 4}, // Employee 6
                {6, 3, 5, 9, 2, 7, 9}  // Employee 7
        };

        int[][] employeeTotalHours = new int[workHours.length][2]; // 第一个元素是员工ID，第二个是总小时数
        for (int i = 0; i < workHours.length; i++) {
            int totalHours = 0;
            for (int j = 0; j < workHours[i].length; j++) {
                totalHours += workHours[i][j];
            }
            employeeTotalHours[i][0] = i; // 员工ID
            employeeTotalHours[i][1] = totalHours; // 总小时数
        }
        Arrays.sort(employeeTotalHours, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]); // 降序排列
            }
        });
        System.out.println("Employee ID\tTotal Hours");
        for (int i = 0; i < employeeTotalHours.length; i++) {
            System.out.println(employeeTotalHours[i][0] + "\t\t" + employeeTotalHours[i][1]);
        }
    }
}
