package afterclass;

import java.util.Scanner;

public class exe8_1 {
    public static void main(String[] args) {
        double matrix[][]=new double[3][4];
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a 3-by-4 matrix row by row: ");
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++)
                matrix[i][j]=in.nextDouble();
        }
        sumColumn(matrix);

    }
    public static void sumColumn(double[][]matrix) {
        int i=0;
        double column=0;
        for(int j=0;j<4;j++) {
            column=0;
            for(i=0;i<matrix.length;i++){
                column+=matrix[i][j];
            }
            System.out.println("Sum of the elements at column "+j+" is "+column);

        }
    }



}
