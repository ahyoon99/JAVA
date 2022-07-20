package Algorithm;
import java.util.*;

public class B16194 {
    // 1. Bottom-up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] price = new int[n+1];
    //     for(int i=1;i<=n;i++){
    //         price[i]=sc.nextInt();
    //     }
    //     int[] min_price = new int[n+1];
    //     min_price[1]=price[1];
    //     for(int i=2;i<=n;i++){
    //         min_price[i]=price[i];
    //         for(int j=1;j<i;j++){
    //             if(min_price[i]>price[j]+min_price[i-j]){
    //                 min_price[i] = price[j]+min_price[i-j];
    //             }
    //         }
    //     }
    //     System.out.println(min_price[n]);
    // } 
    
    // 2. Top-down
    static int go(int n, int[] min_price, int[] price){
        if(min_price[n]>0){
            return min_price[n];
        }
        else{
            min_price[n]=price[n];
            for(int i=1;i<n;i++){
                if(min_price[n]>price[i]+go(n-i,min_price, price)){
                    min_price[n] = price[i]+go(n-i,min_price, price);
                }
            }
        }
        return min_price[n];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n+1];
        for(int i=1;i<=n;i++){
            price[i]=sc.nextInt();
        }
        int[] min_price = new int[n+1];
        System.out.println(go(n,min_price, price));
    }
}