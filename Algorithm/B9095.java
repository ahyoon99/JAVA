package Algorithm;

import java.util.Scanner;

public class B9095 {

    // 1. 
    // public static int func(int n){
    //     if(n==1 || n==0){
    //         return 1;
    //     }
    //     else if(n==2){
    //         return 2;
    //     }
    //     int count = 0;
    //     for(int i=1;i<=3;i++){
    //         count+=func(n-i);
    //     }
    //     return count;
    // }
    

    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int T = sc.nextInt();
    //     for(int i=0;i<T;i++){
    //         int n = sc.nextInt();
    //         System.out.println(func(n));
    //     }
    // }

    // 2. Top-down (재귀)
    static int go(int n, int[] num){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        else{
            num[n] = go(n-1, num)+go(n-2, num)+go(n-3, num);
        }
        return num[n];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int test = sc.nextInt();
            int[] num = new int[test+1];
            System.out.println(go(test,num));
        }
    }
}
