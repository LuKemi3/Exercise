package afterclass;

import java.util.Scanner;

public class exe8_5 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        double[][]matrix1=new double[3][3];
        double[][]matrix2=new double[3][3];
        System.out.println("Enter matrix1: ");
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++)
                matrix1[i][j]=in.nextDouble();
        }
        System.out.println("Enter matrix2: ");
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++)
                matrix2[i][j]=in.nextDouble();
        }
        double[][] sum=addMatrix(matrix1,matrix2);
        System.out.println("The sum of two matrix is ");
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static double[][] addMatrix(double[][]matrix1,double[][]matrix2){
        double[][] sum=new double[3][3];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                sum[i][j]=matrix1[i][j]+matrix2[i][j];
            }
        }
        return sum;
    }


}
