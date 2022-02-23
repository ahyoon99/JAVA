package Algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B10973 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int i = n-1;
        while(i>0 && arr[i-1]<arr[i]){
            i--;
        }

        if(i==0){
            System.out.println(-1);
            return;
        }
        int j = n-1;
        while(j>0 && arr[j]>arr[i-1]){
            j--;
        }
        int temp = arr[i-1];
        arr[i-1]=arr[j];
        arr[j]=temp;
        // while(i<j){
        //     temp = arr[i];
        //     arr[i]=arr[j];
        //     arr[j]=temp;
        //     i++;
        //     j--;
        // }
        Arrays.sort(arr, i,n,Collections.reverseOrder());
        for(int t = 0;t<n;t++){
            System.out.print(arr[t]+" ");
        }
        return;
    }
    
}
