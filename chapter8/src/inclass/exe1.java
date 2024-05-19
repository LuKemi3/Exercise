package inclass;

import java.util.Arrays;

public class exe1 {

    public static void main(String[] args) {
        int[][]arr=new int[5][5];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=(int)(Math.random()*(100-3+1)+3);
            }
        }
        int max=0;
        //寻找最大数
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
               if(arr[i][j]>max)
                   max=arr[i][j];
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println("the max value is :"+max);
    }
}
