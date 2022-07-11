package Algorithm;

import java.util.Scanner;

public class B11052 {
    // 1. Bottom-up (for문)
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n+1];
        int[] maxPrice = new int[n+1];

        for(int i=1;i<=n;i++){
            price[i]=sc.nextInt();
        }

        maxPrice[1]=price[1];
        for(int i=2;i<=n;i++){
            int max=price[i];
            for(int j=1;j<i;j++){
                if(max<maxPrice[i-j]+price[j]){
                    max = maxPrice[i-j]+price[j];
                }
            }
            maxPrice[i] = max;
        }
        System.out.println(maxPrice[n]);
    }
}
