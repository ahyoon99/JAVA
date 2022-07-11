package Algorithm;

import java.util.Scanner;

public class B11052 {
    // // 1. Bottom-up (for문)
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] price = new int[n+1];
    //     int[] maxPrice = new int[n+1];

    //     for(int i=1;i<=n;i++){
    //         price[i]=sc.nextInt();
    //     }

    //     maxPrice[1]=price[1];
    //     for(int i=2;i<=n;i++){
    //         int max=price[i];
    //         for(int j=1;j<i;j++){
    //             if(max<maxPrice[i-j]+price[j]){
    //                 max = maxPrice[i-j]+price[j];
    //             }
    //         }
    //         maxPrice[i] = max;
    //     }
    //     System.out.println(maxPrice[n]);
    // }

    // 2. Top-down (재귀)
    static int go(int n, int[] price, int[] maxPrice){
        if(n==1){
            maxPrice[1]=price[1];
            return price[1];
        }
        if(maxPrice[n]>0){
            return maxPrice[n];
        }
        maxPrice[n] = price[n];
        for(int i=1;i<n;i++){
            if(maxPrice[n]<go(n-i, price, maxPrice)+price[i]){
                maxPrice[n] = go(n-i, price, maxPrice)+price[i];
            }
        }
        return maxPrice[n];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n+1];
        int[] maxPrice = new int[n+1];
        
        for(int i=1;i<=n;i++){
            price[i]=sc.nextInt();
        }
        System.out.println(go(n,price, maxPrice));
    }
}
