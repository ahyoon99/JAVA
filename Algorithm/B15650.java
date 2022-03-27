package Algorithm;

import java.util.Scanner;

public class B15650 {

    public static void go(int[] num, int[] arr, int m, int i, int size){
        if(size==m){
            for(int index=0;index<m;index++){
                System.out.print(arr[index]+" ");
            }
            System.out.println();
            return;
        }
        if(num.length<=i){
            return;
        }
        arr[size]=num[i];
        go(num, arr, m,i+1, size+1);

        arr[size]=0;
        go(num, arr, m, i+1, size);

        return;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = new int[n];
        int[] arr = new int[m];
        for(int i=0;i<n;i++){
            num[i]=i+1;
        }

        go(num, arr, m,0,0);

    }
    
}
