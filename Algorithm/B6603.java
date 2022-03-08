package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B6603 {

    // 1. 순열 사용
    // public static boolean next_permutation(int[] arr, int n){
    //     int i=n-1;
    //     while(i>0 && arr[i-1]>=arr[i]){
    //         i--;
    //     }
    //     if(i==0){
    //         return false;
    //     }
    //     int j=n-1;
    //     while(j>0 && arr[i-1]>=arr[j]){
    //         j--;
    //     }
    //     int temp=arr[i-1];
    //     arr[i-1] = arr[j];
    //     arr[j]=temp;
    //     Arrays.sort(arr, i,n);
    //     return true;
    // }
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
        
    //     while(true){
    //         int n=sc.nextInt();
    //         if(n==0){
    //             return;
    //         }
    //         int[] num = new int[n];
    //         int[] arr = new int[n];
    //         for(int i=0;i<n;i++){
    //             num[i] = sc.nextInt();
    //         }
    //         Arrays.sort(num);

    //         for(int i=n-1;i>=6;i--){
    //             arr[i]=1;
    //         }

    //         do{
    //             for(int i=0;i<n;i++){
    //                 if(arr[i]==0){
    //                     System.out.print(num[i]+" ");
    //                 }
    //             }
    //             System.out.println();
    //         }while(next_permutation(arr, n));
    //         System.out.println();

    //     }
    // }
    
    // 2. 재귀함수 사용

    public static void go(int n, int[] arr, int[] lotto, int i, int size){
        if(size==n){
            for(int index=0;index<n;index++){
                System.out.print(lotto[index]+" ");
            }
            System.out.println();
            return;
        }
        if(i>=arr.length){
            return;
        }

        lotto[size]=arr[i];
        go(n,arr,lotto,i+1,size+1);
        lotto[size]=0;
        go(n,arr,lotto,i+1,size);
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            int num = sc.nextInt();
            if(num==0){
                return;
            }
            int[] arr = new int[num];
            int[] lotto = new int[6];
            for(int i=0;i<num;i++){
                arr[i] = sc.nextInt();
            }
            go(6,arr,lotto,0,0);
            System.out.println();
        }
    }
}
