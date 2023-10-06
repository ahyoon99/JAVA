package Algorithm;

import java.util.*;
import java.io.*;

public class H233551 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] num1 = new int[n];
        int[] num2 = new int[m];

        for(int i=0;i<n;i++){
            num1[i]=sc.nextInt();
        }

        for(int i=0;i<m;i++){
            num2[i]=sc.nextInt();
        }

        int[][] dp = new int[n][m];
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(num1[i]==num2[j]){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    max = max<dp[i][j] ? dp[i][j] : max;
                }
            }
        }
        System.out.println(max);
    }
}
