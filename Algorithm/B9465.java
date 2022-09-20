package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B9465 {
    // 방법 1 (Bottom-up)
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int tc = sc.nextInt();
    //     for(int i=0;i<tc;i++){
    //         int n = sc.nextInt();
    //         int[][] price = new int[2][n];
    //         for(int j=0;j<2;j++){
    //             for(int k=0;k<n;k++){
    //                 price[j][k]=sc.nextInt();
    //             }
    //         }
    //         int[][] result = new int[n][3];
    //         result[0][0]=0;
    //         result[0][1]=price[0][0];
    //         result[0][2]=price[1][0];
    //         for(int j=1;j<n;j++){
    //             result[j][0]=Math.max(Math.max(result[j-1][0], result[j-1][1]), result[j-1][2]);
    //             result[j][1]=Math.max(result[j-1][0], result[j-1][2])+price[0][j];
    //             result[j][2]=Math.max(result[j-1][0], result[j-1][1])+price[1][j];
    //         }
    //         System.out.println(Math.max(Math.max(result[n-1][0], result[n-1][1]), result[n-1][2]));
    //     }
    // }

    // 방법 2 (Top-down)
    
    static int go(int n, int x, int[][] sticker, int[][] price){
        if(price[n][x]!=-1){
            return price[n][x];
        }
        if(x==0){
            price[n][x] = Math.max(Math.max(go(n-1,0,sticker,price), go(n-1,1,sticker,price)), go(n-1,2,sticker,price));
            return price[n][x];
        }
        if(x==1){
            price[n][x]=Math.max(go(n-1,0,sticker,price), go(n-1,2,sticker,price))+sticker[0][n];
            return price[n][x];
        }
        if(x==2){
            price[n][x]=Math.max(go(n-1,0,sticker,price), go(n-1,1,sticker,price))+sticker[1][n];
            return price[n][x];
        }
        return price[n][x];
    }
    static public void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int tc = sc.nextInt();
        for(int T=0;T<tc;T++){
            int n = sc.nextInt();
            int[][] sticker = new int[2][n];
            int[][] price = new int[n][3];

            for(int i=0;i<2;i++){
                for(int j=0;j<n;j++){
                    sticker[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++){
                Arrays.fill(price[i], -1);
            }

            price[0][0] = 0;
            price[0][1] = sticker[0][0];
            price[0][2] = sticker[1][0];

            for(int i=0;i<3;i++){
                go(n-1,i,sticker,price);
            }
            int result = Math.max(Math.max(price[n-1][0], price[n-1][1]), price[n-1][2]);
            System.out.println(result);
        }
    }
}
