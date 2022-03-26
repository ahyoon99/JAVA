package Algorithm;

import java.util.Scanner;

public class B14501 {

    public static int go(int[] day, int[] price, int n, int i, int total_price, int max_price){
        int max;
        if(i==n-1){
            if(day[i]==1){
                total_price+=price[i];
            }
        }
        if(i>=n-1){
            if(max_price<total_price){
                max_price=total_price;
            }
            return max_price;
        }
        if(i+day[i]<=n){
            max=go(day, price, n, i+day[i],total_price+price[i],max_price);
            if(max_price<max){
                max_price=max;
            }
        }
        max=go(day,price, n,i+1,total_price, max_price);
        if(max_price<max){
            max_price=max;
        }
        return max_price;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] day = new int[n];
        int[] price = new int[n];

        for(int i=0;i<n;i++){
            day[i]=sc.nextInt();
            price[i]=sc.nextInt();
        }

        System.out.println(go(day,price,n,0,0,0));

    }
    
}
