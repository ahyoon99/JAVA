package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B10974 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int cnt = 1;
        for(int i=0, j=n;i<n;i++,j--){
            arr[i]=i+1;
            cnt*=j;
        }

        for(int i=0;i<cnt;i++){
            if(i==0){
                for(int t=0;t<n;t++){
                    System.out.print(arr[t]+" ");
                }
                System.out.println();
                continue;
            }
            int j=n-1;
            while(j>0 && arr[j-1]>arr[j]){
                j--;
            }
            int k=n-1;
            while(k>0 && arr[k]<arr[j-1]){
                k--;
            }
            int temp = arr[j-1];
            arr[j-1]=arr[k];
            arr[k]=temp;
            Arrays.sort(arr, j,n);
            for(int t=0;t<n;t++){
                System.out.print(arr[t]+" ");
            }
            System.out.println();
        }
    }
    
}
