package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B15657 {
    public static void go(int[] num, int[] arr, int index, int start, int n, int m){
        if(index==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        if(index>=n){
            return;
        }
        for(int i=start;i<n;i++){
            arr[index]=num[i];
            go(num,arr,index+1, i, n,m);
            arr[index]=0;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = new int[n];
        int[] arr = new int[m];

        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);
        go(num, arr, 0,0,n,m);  
        
    }
}
