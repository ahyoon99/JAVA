package Algorithm;

import java.util.Scanner;

public class B15650 {

    // 방법 1
    // public static void go(int[] num, int[] arr, int m, int i, int size){
    //     if(size==m){
    //         for(int index=0;index<m;index++){
    //             System.out.print(arr[index]+" ");
    //         }
    //         System.out.println();
    //         return;
    //     }
    //     if(num.length<=i){
    //         return;
    //     }
    //     arr[size]=num[i];
    //     go(num, arr, m,i+1, size+1);

    //     arr[size]=0;
    //     go(num, arr, m, i+1, size);

    //     return;
    // }
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();

    //     int[] num = new int[n];
    //     int[] arr = new int[m];
    //     for(int i=0;i<n;i++){
    //         num[i]=i+1;
    //     }

    //     go(num, arr, m,0,0);

    // }

    // 방법 2 : Code Plus 강의 내용
    // static int[] arr = new int[9];
    // static boolean[] check = new boolean[9];

    // public static void go(int index, int start, int n, int m){
    //     if(index==m){
    //         for(int i=0;i<m;i++){
    //             System.out.print(arr[i]+" ");
    //         }
    //         System.out.println();
    //         return;
    //     }
    //     if(index>=m){
    //         return;
    //     }
    //     for(int i=start;i<=n;i++){
    //         if(check[i]){
    //             continue;
    //         }
    //         else{
    //             check[i]=true;
    //             arr[index]=i;
    //             go(index+1,i+1, n,m);
    //             check[i]=false;
    //             arr[index]=0;
    //         }
    //     }
    // }

    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
        
    //     go(0,1,n,m);
    //     return;
    // }

    // 방법 3 : Code Plus 강의 내용
    static int[] arr = new int[10];

    public static void go(int index, int arr_size, int n, int m){
        if(arr_size==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        if(index>n){
            return;
        }
        arr[arr_size]=index;
        go(index+1, arr_size+1, n,m);
        arr[arr_size]=0;
        go(index+1, arr_size, n,m);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();

        go(1,0,n,m);
        
        return;
    }
    
}
