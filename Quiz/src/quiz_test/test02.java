package quiz_test;

import java.util.Arrays;
import java.util.Scanner;

//remove val
public class test02 {
    public static void main(String[] args) {
        System.out.println("please enter the number of array");
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        int[]arrayi=new int[num];
        System.out.println("please enter the array of "+num+"numbers");
        for(int i=0;i<arrayi.length;i++){
            arrayi[i]=sc.nextInt();
        }
        System.out.println("Please enter the num you want to remove");
        int re=sc.nextInt();
        System.out.println("nums= "+ Arrays.toString(removed(arrayi,re)));
        System.out.println("Size= "+removed(arrayi,re).length);

    }
    public static int[] removed(int []arrayi,int a){
        int numo=0;
        for(int i=0;i<arrayi.length;i++){
            if(arrayi[i]!=a)
                numo++;
        }
        int k=0;
        int []arrayo=new int[numo];
        for(int i=0;i<arrayi.length;i++){
            if(arrayi[i]!=a) {
                arrayo[k] = arrayi[i];
                k++;
            }


        }
        return arrayo;


    }
}
