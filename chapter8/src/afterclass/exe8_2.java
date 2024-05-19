package afterclass;

import java.util.Scanner;

//对角线中元素
public class exe8_2 {
    public static void main(String[] args) {
        double matrix[][]=new double[4][4];
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a 4-by-4 matrix row by row: ");
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++)
                matrix[i][j]=in.nextDouble();
        }
        System.out.println("sumMajorDiagonal is"+sumMajorDiagonal(matrix));

    }
    public static double sumMajorDiagonal(double[][] m){
        double sum=0;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                if(i==j)
                    sum=sum+m[i][j];
            }
        }
        return sum;
    }
}
