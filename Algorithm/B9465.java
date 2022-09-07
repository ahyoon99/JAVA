package Algorithm;

import java.util.Scanner;

public class B9465 {
    // 방법 1 (Bottom-up)
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++){
            int n = sc.nextInt();
            int[][] price = new int[2][n];
            for(int j=0;j<2;j++){
                for(int k=0;k<n;k++){
                    price[j][k]=sc.nextInt();
                }
            }
            int[][] result = new int[n][3];
            result[0][0]=0;
            result[0][1]=price[0][0];
            result[0][2]=price[1][0];
            for(int j=1;j<n;j++){
                result[j][0]=Math.max(Math.max(result[j-1][0], result[j-1][1]), result[j-1][2]);
                result[j][1]=Math.max(result[j-1][0], result[j-1][2])+price[0][j];
                result[j][2]=Math.max(result[j-1][0], result[j-1][1])+price[1][j];
            }
            System.out.println(Math.max(Math.max(result[n-1][0], result[n-1][1]), result[n-1][2]));
        }
    }
}
