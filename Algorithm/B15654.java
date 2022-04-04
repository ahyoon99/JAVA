package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B15654 {

    static boolean[] check = new boolean[9];
    static int[] arr = new int[9];

    public static void go(int[] num, int index, int n, int m){
        if(index==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        if(index>m){
            return;
        }
        for(int i=0;i<n;i++){
            if(check[i]){
                continue;
            }
            else{
                check[i]=true;
                arr[index]=num[i];
                go(num, index+1, n,m);
                check[i]=false;
                arr[index]=0;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);

        go(num, 0,n,m);

        return;
    }
    
}
