package quiz_test;

import java.util.Arrays;

//取平均数
public class test01 {
    public static void main(String[] args) {
        int[]array1=new int[5];
        for(int i=0;i<5;i++){
            array1[i]= (int)(Math.random()*(12-3)+3);
        }
        System.out.println(Arrays.toString(array1));
        double  average=getAverage(array1);
        System.out.println(average);

    }
    public static double getAverage(int[]array1){
        double sum=0;
        for(int j=0;j<5;j++){
            sum=sum+array1[j];
        }
        return sum/5;
    }
}
