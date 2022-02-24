package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B10819 {

    public static boolean next_permutation(int[] arr, int n){

        int i=n-1;
        while(i>0 && arr[i-1]>=arr[i]){
            i--;
        }
        if(i==0){
            return false;
        }
        int j=n-1;
        while(j>0 && arr[i-1]>=arr[j]){
            j--;
        }
        int temp = arr[i-1];
        arr[i-1]=arr[j];
        arr[j]=temp;

        Arrays.sort(arr, i, n);

        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int max=-1;
        do{
            int result = 0;
            for(int i=0;i<n-1;i++){
                result+=Math.abs(arr[i]-arr[i+1]);
            }
            if(max<result){
                max=result;
            }
        }while(next_permutation(arr, n));

        System.out.println(max);
    }
    
}
