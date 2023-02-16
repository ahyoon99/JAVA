package Algorithm;

import java.util.*;

public class B1149 {
    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[][] price = new int[n+1][4];
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=3;j++){
    //             price[i][j]=sc.nextInt();
    //         }
    //     }

    //     int[][] minPrice = new int[n+1][4];
    //     for(int i=1;i<=3;i++){
    //         minPrice[1][i]=price[1][i];
    //     }
        
    //     for(int i=2;i<=n;i++){
    //         minPrice[i][1] = Math.min(minPrice[i-1][2], minPrice[i-1][3])+price[i][1];
    //         minPrice[i][2] = Math.min(minPrice[i-1][1], minPrice[i-1][3])+price[i][2];
    //         minPrice[i][3] = Math.min(minPrice[i-1][1], minPrice[i-1][2])+price[i][3];
    //     }

    //     Arrays.sort(minPrice[n]);
    //     System.out.println(minPrice[n][1]);
    // }

    // 방법 2 : Top down
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] price = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                price[i][j]=sc.nextInt();
            }
        }

        int[][] result = new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(result[i],-1);
        }
        for(int i=0;i<3;i++){
            result[0][i]=price[0][i];
        }
        for(int i=0;i<3;i++){
            go(price, result, n-1, i);
        }

        Arrays.sort(result[n-1]);
        System.out.println(result[n-1][0]);
    }

    static int go(int[][] price, int[][] result, int n, int m){
        if(result[n][m]!=-1){
            return result[n][m];
        }
        if(m==0){
            result[n][m] = Math.min(go(price, result, n-1, 1), go(price, result, n-1, 2))+price[n][m];
        }
        else if(m==1){
            result[n][m] = Math.min(go(price, result, n-1, 0), go(price, result, n-1, 2))+price[n][m];
        }
        else if(m==2){
            result[n][m] = Math.min(go(price, result, n-1, 0), go(price, result, n-1, 1))+price[n][m];
        }
        return result[n][m];
    }
}
