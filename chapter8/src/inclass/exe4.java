package inclass;

import java.util.Arrays;

public class exe4 {
    public static void main(String[] args) {
        int[][] yanghui=new int[7][7];
        for(int i=0;i<yanghui.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    yanghui[i][j]=1;
                else{
                    yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(yanghui));
    }
}
